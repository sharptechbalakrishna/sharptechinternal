package com.sharp.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.dto.ReqRes;
import com.sharp.model.Employee;
import com.sharp.repository.EmployeeRepo;
import com.sharp.service.OtpService;


@RestController
@RequestMapping("/auth")
public class OtpController {
	
	
	@Autowired
    private OtpService otpService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/forgot-password")
    public ResponseEntity<ReqRes> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        ReqRes response = otpService.generateAndSendOtp(email);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");	
        String newPassword = request.get("newPassword");

        if (otpService.validateOtp(email, otp)) {
            Employee user = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User not registered"));
            user.setPassword(passwordEncoder.encode(newPassword));
            employeeRepo.save(user);
            return ResponseEntity.ok("Password has been reset successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }
    
    
}
