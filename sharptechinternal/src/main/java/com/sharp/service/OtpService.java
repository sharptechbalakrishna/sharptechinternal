package com.sharp.service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sharp.dto.ReqRes;
import com.sharp.model.Otp;
import com.sharp.repository.EmployeeRepo;
import com.sharp.repository.OtpRepository;


@Service
public class OtpService {
	
	@Autowired
    private OtpRepository otpRepository;

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private EmployeeRepo employeeRepo;


    
    public ReqRes generateAndSendOtp(String email) {
        ReqRes response = new ReqRes();
        try {
            // Check if the user is registered
            boolean userExists = employeeRepo.existsByEmail(email);
            if (!userExists) {
                throw new NoSuchElementException("User not registered");
            }

            // Generate and send OTP
            Optional<Otp> existingOtp = otpRepository.findByEmail(email);
            String otp = String.valueOf(new Random().nextInt(999999));

            if (existingOtp.isPresent()) {
                Otp otpEntity = existingOtp.get();
                otpEntity.setOtp(otp);
                otpEntity.setExpiryDate(new Date(System.currentTimeMillis() + 300000)); // 5 minutes validity
                otpRepository.save(otpEntity);
            } else {
                Otp otpEntity = new Otp();
                otpEntity.setEmail(email);
                otpEntity.setOtp(otp);
                otpEntity.setExpiryDate(new Date(System.currentTimeMillis() + 300000)); // 5 minutes validity
                otpRepository.save(otpEntity);
            }
            emailService.sendOtpEmail(email, otp);

            response.setStatusCode(200);
            response.setMessage("OTP has been sent to your email");
        } catch (NoSuchElementException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }

        return response;
    }
    

    
    public boolean validateOtp(String email, String otp) {
        Optional<Otp> otpEntity = otpRepository.findByEmailAndOtp(email, otp);
        if (otpEntity.isPresent() && otpEntity.get().getExpiryDate().after(new Date())) {
            otpRepository.delete(otpEntity.get());
            return true;
        }
        return false;
    }

}
