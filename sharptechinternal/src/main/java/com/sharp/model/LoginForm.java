package com.sharp.model;

import jakarta.persistence.Table;

@Table(name = "loginform")
public class LoginForm {
	public String empEmail;
	public String empPassword;
	
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
}
