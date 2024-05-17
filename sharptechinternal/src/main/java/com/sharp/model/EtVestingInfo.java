package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table;

@Entity
@Table(name = "etvestinginfo")
public class EtVestingInfo {
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String  considerationAmount;
	private String deedType;
	private String grantor;;
	private String grantee;
	private String vesting;
    private String instrBookPage;
    private Date datedDate;
    private Date recordDate;
    private String note;
    private Integer indicator;
    
    
    
    
	public EtVestingInfo() {
		super();
	}
	
	public EtVestingInfo(Long slNo, String  considerationAmount, String deedType, String grantor, String grantee,
			String vesting, String instrBookPage, Date datedDate, Date recordDate, String note, Integer indicator) {
		super();
		this.slNo = slNo;
		this.considerationAmount = considerationAmount;
		this.deedType = deedType;
		this.grantor = grantor;
		this.grantee = grantee;
		this.vesting = vesting;
		this.instrBookPage = instrBookPage;
		this.datedDate = datedDate;
		this.recordDate = recordDate;
		this.note = note;
		this.indicator = indicator;
	}
	
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String  getConsiderationAmount() {
		return considerationAmount;
	}
	public void setConsiderationAmount(String  considerationAmount) {
		this.considerationAmount = considerationAmount;
	}
	public String getDeedType() {
		return deedType;
	}
	public void setDeedType(String deedType) {
		this.deedType = deedType;
	}
	public String getGrantor() {
		return grantor;
	}
	public void setGrantor(String grantor) {
		this.grantor = grantor;
	}
	public String getGrantee() {
		return grantee;
	}
	public void setGrantee(String grantee) {
		this.grantee = grantee;
	}
	public String getVesting() {
		return vesting;
	}
	public void setVesting(String vesting) {
		this.vesting = vesting;
	}
	public String getInstrBookPage() {
		return instrBookPage;
	}
	public void setInstrBookPage(String instrBookPage) {
		this.instrBookPage = instrBookPage;
	}
	public Date getDatedDate() {
		return datedDate;
	}
	public void setDatedDate(Date datedDate) {
		this.datedDate = datedDate;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getIndicator() {
		return indicator;
	}
	public void setIndicator(Integer indicator) {
		this.indicator = indicator;
	}

	public void setOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		
	}

	public void setSomeProperty(String string) {
		// TODO Auto-generated method stub
		
	}



}
