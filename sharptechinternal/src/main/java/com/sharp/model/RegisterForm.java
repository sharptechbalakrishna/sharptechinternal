package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registerform")
public class RegisterForm {
	
	
	@Id
	@GeneratedValue
	private Long slNo;
	
    @Column(unique = true)
	private String empId;
	
	private String empFirstName;
	private String empMiddleName;
	private String empLastName;
	
	private String empMotherName;
	private String empFatherName;
	
	@Column(unique = true)
	private String empEmail;
	private String empPassword;
	
	private Date empDateOfBirth;
	
	
	private String empAddress;
	private Long empSalary;
	
	private Date empJoiningDate;
	private Date empReleavingDate;
	
	private String empQualification;
	private String empDesignation;
	
	private Long empAadhaarNumber;
	private String empPanNumber;
	
	private String empRemarks;
	
	
	
	public RegisterForm() {
		super();
	}
	public RegisterForm(Long slNo, String empId, String empFirstName, String empMiddleName, String empLastName,
			String empMotherName, String empFatherName, String empEmail, String empPassword, Date empDateOfBirth,
			String empAddress, Long empSalary, Date empJoiningDate, Date empReleavingDate, String empQualification,
			String empDesignation, Long empAadhaarNumber, String empPanNumber, String empRemarks) {
		super();
		this.slNo = slNo;
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.empMotherName = empMotherName;
		this.empFatherName = empFatherName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.empDateOfBirth = empDateOfBirth;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
		this.empJoiningDate = empJoiningDate;
		this.empReleavingDate = empReleavingDate;
		this.empQualification = empQualification;
		this.empDesignation = empDesignation;
		this.empAadhaarNumber = empAadhaarNumber;
		this.empPanNumber = empPanNumber;
		this.empRemarks = empRemarks;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpMiddleName() {
		return empMiddleName;
	}
	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpMotherName() {
		return empMotherName;
	}
	public void setEmpMotherName(String empMotherName) {
		this.empMotherName = empMotherName;
	}
	public String getEmpFatherName() {
		return empFatherName;
	}
	public void setEmpFatherName(String empFatherName) {
		this.empFatherName = empFatherName;
	}
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
	public Date getEmpDateOfBirth() {
		return empDateOfBirth;
	}
	public void setEmpDateOfBirth(Date empDateOfBirth) {
		this.empDateOfBirth = empDateOfBirth;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Long getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Long empSalary) {
		this.empSalary = empSalary;
	}
	public Date getEmpJoiningDate() {
		return empJoiningDate;
	}
	public void setEmpJoiningDate(Date empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}
	public Date getEmpReleavingDate() {
		return empReleavingDate;
	}
	public void setEmpReleavingDate(Date empReleavingDate) {
		this.empReleavingDate = empReleavingDate;
	}
	public String getEmpQualification() {
		return empQualification;
	}
	public void setEmpQualification(String empQualification) {
		this.empQualification = empQualification;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public Long getEmpAadhaarNumber() {
		return empAadhaarNumber;
	}
	public void setEmpAadhaarNumber(Long empAadhaarNumber) {
		this.empAadhaarNumber = empAadhaarNumber;
	}
	public String getEmpPanNumber() {
		return empPanNumber;
	}
	public void setEmpPanNumber(String empPanNumber) {
		this.empPanNumber = empPanNumber;
	}
	public String getEmpRemarks() {
		return empRemarks;
	}
	public void setEmpRemarks(String empRemarks) {
		this.empRemarks = empRemarks;
	}


}