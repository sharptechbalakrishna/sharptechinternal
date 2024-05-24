package com.sharp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharp.model.LoginHistory;

public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Long> {
	
	Optional<LoginHistory> findTopByEmailOrderBySlNoDesc(String email);

}
