package com.sharp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sharp.repository.EmployeeRepo;


//import com.fullstack.backend.repository.UsersRepo;

@Service
public class OurUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		return employeeRepo.findByEmail(username).orElseThrow();
	}
}
