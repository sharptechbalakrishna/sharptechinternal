package com.sharp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharp.dto.ReqRes;
import com.sharp.model.LoginOtp;
import com.sharp.model.Otp;
import com.sharp.repository.EmployeeRepo;
import com.sharp.repository.LoginOtpRepository;
import com.sharp.repository.OtpRepository;

import jakarta.transaction.Transactional;


@Service
public class OtpService {
	
	@Autowired
    private OtpRepository otpRepository;

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    @Autowired
    private LoginOtpRepository loginOtpRepository;


    // This method is use for the generating otp for the resetpassword
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
    

    // Validatign the otp for the forget password
    public boolean validateOtp(String email, String otp) {
        Optional<Otp> otpEntity = otpRepository.findByEmailAndOtp(email, otp);
        if (otpEntity.isPresent() && otpEntity.get().getExpiryDate().after(new Date())) {
            otpRepository.delete(otpEntity.get());
            return true;
        }
        return false;
    }
    
    
    // Generating the otp for the login 
    public String generateOtp(String email) {
        // Generate OTP (e.g., a random 6-digit number)
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        
        // Set expiration time to 5 minutes from now
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);
        Date expirationTime = calendar.getTime();

        // Check if an OTP already exists for this email
        Optional<LoginOtp> existingOtpOpt = loginOtpRepository.findByEmail(email);
        if (existingOtpOpt.isPresent()) {
            // If OTP exists, update it
            LoginOtp existingOtp = existingOtpOpt.get();
            existingOtp.setOtp(otp);
            existingOtp.setExpirationTime(expirationTime);
            loginOtpRepository.save(existingOtp);
        } else {
            // If OTP does not exist, create a new one
            LoginOtp loginOtp = new LoginOtp();
            loginOtp.setEmail(email);
            loginOtp.setOtp(otp);
            loginOtp.setExpirationTime(expirationTime);
            loginOtpRepository.save(loginOtp);
        }

        return otp;
    }
    

    public Optional<LoginOtp> getOtp(String email) {
        return loginOtpRepository.findByEmail(email);
    }
    
    @Transactional
    public void deleteOtp(String email) {
        loginOtpRepository.deleteByEmail(email);
    }

}
