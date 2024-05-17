package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ettaxinstallment")
public class EtTaxInstallment {
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String amount;
	private String status;
	private Date paidDueDate;
	
	
	
	public EtTaxInstallment() {
		super();
	}
	public EtTaxInstallment(Long slNo, String amount, String status, Date paidDueDate) {
		super();
		this.slNo = slNo;
		this.amount = amount;
		this.status = status;
		this.paidDueDate = paidDueDate;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPaidDueDate() {
		return paidDueDate;
	}
	public void setPaidDueDate(Date paidDueDate) {
		this.paidDueDate = paidDueDate;
	}
	public void setOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
