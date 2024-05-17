package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activejudgementsandlines")
public class AbsActiveJudgementsAndLines {
	//author balakrishna
	
	@Id
	@GeneratedValue
	private Long sno;
	private String caseType;
	private String bkPgCaseNo;
	private Date recordingDate;
	private String Amount;
	
	
	
	public AbsActiveJudgementsAndLines() {
		super();
	}
	
	
	public AbsActiveJudgementsAndLines(Long sno, String caseType, String bkPgCaseNo, Date recordingDate,
			String amount) {
		super();
		this.sno = sno;
		this.caseType = caseType;
		this.bkPgCaseNo = bkPgCaseNo;
		this.recordingDate = recordingDate;
		Amount = amount;
	}
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getBkPgCaseNo() {
		return bkPgCaseNo;
	}
	public void setBkPgCaseNo(String bkPgCaseNo) {
		this.bkPgCaseNo = bkPgCaseNo;
	}
	public Date getRecordingDate() {
		return recordingDate;
	}
	public void setRecordingDate(Date recordingDate) {
		this.recordingDate = recordingDate;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	
	
	
	

}
