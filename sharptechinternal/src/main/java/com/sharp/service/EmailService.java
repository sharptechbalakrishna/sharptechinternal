package com.sharp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	// This mail template for the forget passsord
	public void sendOtpEmail(String toEmail, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Password Reset Request - OTP Enclosed");

		String emailContent = "Dear SharpTech User,\n\n"
				+ "We received a request to reset the password for your account.\n\n"
				+ "Your One-Time Password (OTP) for password reset is: " + otp + "\n\n"
				+ "Please enter this OTP in the application to proceed with resetting your password. "
				+ "For security reasons, this OTP is valid for 5 minutes only.\n\n"
				+ "If you did not request a password reset, please ignore this email. "
				+ "Your account remains secure.\n\n" + "Best regards,\n" + "The Development Team";

		message.setText(emailContent);
		javaMailSender.send(message);
	}

	// This mail is for the login purpose
	public void sendOtp(String email, String otp) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Login Verification - OTP Enclosed");

		String emailContent = "Dear SharpTech User,\n\n" + "We received a request to log in to your account.\n\n"
				+ "Your One-Time Password (OTP) for login verification is: " + otp + "\n\n"
				+ "Please enter this OTP in the application to proceed with logging into your account. "
				+ "For security reasons, this OTP is valid for 5 minutes only.\n\n"
				+ "If you did not request a login, please ignore this email. " + "Your account remains secure.\n\n"
				+ "Best regards,\n" + "The Development Team" + "\n\n\n" 
				+ "***************************************************************************************";

		message.setText(emailContent);
		javaMailSender.send(message);
	}

}
