package com.sharp.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String empId) {
		
		super("Could Not Found the User with id " + empId);
		
	}

}
