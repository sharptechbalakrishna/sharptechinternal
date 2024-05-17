package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etactivejudgmentsandliens")
public class EtActiveJudgmentsAndLiens {
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String caseNumbe;
	private String description;
	private Date dateRecorded;
    private String amount;
    
    
    
	public EtActiveJudgmentsAndLiens() {
		super();
	}
	public EtActiveJudgmentsAndLiens(Long slNo, String caseNumbe, String description, Date dateRecorded,
			String amount) {
		super();
		this.slNo = slNo;
		this.caseNumbe = caseNumbe;
		this.description = description;
		this.dateRecorded = dateRecorded;
		this.amount = amount;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getCaseNumbe() {
		return caseNumbe;
	}
	public void setCaseNumbe(String caseNumbe) {
		this.caseNumbe = caseNumbe;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateRecorded() {
		return dateRecorded;
	}
	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
    
    
    
    
    
    
    
    
	
}
