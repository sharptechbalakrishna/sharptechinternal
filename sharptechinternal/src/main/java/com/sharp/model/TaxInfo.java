package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxinstallments")
public class TaxInfo {
	@Id
	@GeneratedValue
	private long slno;
	private String amount;
	private String status;
	private Date paidDueDate;
	
	
	public TaxInfo() {
		super();
	}


	public TaxInfo(long slno, String amount, String status, Date paidDueDate) {
		super();
		this.slno = slno;
		this.amount = amount;
		this.status = status;
		this.paidDueDate = paidDueDate;
	}




	public long getSlno() {
		return slno;
	}

	public void setSlno(long slno) {
		this.slno = slno;
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
	
	

}
