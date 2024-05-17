package com.sharp.model;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "absopenmortgagedeedinfo")

public class OpenMortgageDeddInfo {
	
	@Id
	@GeneratedValue
	private Long slno;
	private String mortgagor;
	private String mortgagee;
	private String trustee;
	private String instrBookPage;
	private String amount;
	private Date datedDate;
	private Date recordedDate;
	private Date maturityDate;
	private String mortgageAssignedTo;
	private String assignmentBkPg;
	private Date assignmentDated;
	private Date assignmentRecorded;
	private String comments;
	
	
	
	public OpenMortgageDeddInfo(Long slno, String mortgagor, String mortgagee, String trustee, String instrBookPage,
			String amount, Date datedDate, Date recordedDate, Date maturityDate, String mortgageAssignedTo,
			String assignmentBkPg, Date assignmentDated, Date assignmentRecorded, String comments) {
		super();
		this.slno = slno;
		this.mortgagor = mortgagor;
		this.mortgagee = mortgagee;
		this.trustee = trustee;
		this.instrBookPage = instrBookPage;
		this.amount = amount;
		this.datedDate = datedDate;
		this.recordedDate = recordedDate;
		this.maturityDate = maturityDate;
		this.mortgageAssignedTo = mortgageAssignedTo;
		this.assignmentBkPg = assignmentBkPg;
		this.assignmentDated = assignmentDated;
		this.assignmentRecorded = assignmentRecorded;
		this.comments = comments;
	}
	
	
	
	
	public OpenMortgageDeddInfo() {
		super();
	}


	public Long getSlno() {
		return slno;
	}
	public void setSlno(Long slno) {
		this.slno = slno;
	}
	public String getMortgagor() {
		return mortgagor;
	}
	public void setMortgagor(String mortgagor) {
		this.mortgagor = mortgagor;
	}
	public String getMortgagee() {
		return mortgagee;
	}
	public void setMortgagee(String mortgagee) {
		this.mortgagee = mortgagee;
	}
	public String getTrustee() {
		return trustee;
	}
	public void setTrustee(String trustee) {
		this.trustee = trustee;
	}
	public String getInstrBookPage() {
		return instrBookPage;
	}
	public void setInstrBookPage(String instrBookPage) {
		this.instrBookPage = instrBookPage;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDatedDate() {
		return datedDate;
	}
	public void setDatedDate(Date datedDate) {
		this.datedDate = datedDate;
	}
	public Date getRecordedDate() {
		return recordedDate;
	}
	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getMortgageAssignedTo() {
		return mortgageAssignedTo;
	}
	public void setMortgageAssignedTo(String mortgageAssignedTo) {
		this.mortgageAssignedTo = mortgageAssignedTo;
	}
	public String getAssignmentBkPg() {
		return assignmentBkPg;
	}
	public void setAssignmentBkPg(String assignmentBkPg) {
		this.assignmentBkPg = assignmentBkPg;
	}
	public Date getAssignmentDated() {
		return assignmentDated;
	}
	public void setAssignmentDated(Date assignmentDated) {
		this.assignmentDated = assignmentDated;
	}
	public Date getAssignmentRecorded() {
		return assignmentRecorded;
	}
	public void setAssignmentRecorded(Date assignmentRecorded) {
		this.assignmentRecorded = assignmentRecorded;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
