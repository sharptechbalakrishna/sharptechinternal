package com.sharp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharp.model.LoginOtp;

public interface LoginOtpRepository extends JpaRepository<LoginOtp, Long> {
    Optional<LoginOtp> findByEmail(String email);
    void deleteByEmail(String email);
}