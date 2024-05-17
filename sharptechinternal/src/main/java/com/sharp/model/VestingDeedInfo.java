package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vestingdeedinfo")
public class VestingDeedInfo {
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String considerationAmount;
	private String deedType;
	private String grantor;;
	private String grantee;
	private String vesting;
    private String instaBookPage;
    private Date datedDate;
    private Date recorderdDate;
    private String comments;
    private Integer indicator;
    
    
	
	public VestingDeedInfo(Long slNo, String considerationAmount, String deedType, String grantor, String grantee,
			String vesting, String instaBookPage, Date datedDate, Date recorderdDate, String comments,Integer indicator) {
		super();
		this.slNo = slNo;
		this.considerationAmount = considerationAmount;
		this.deedType = deedType;
		this.grantor = grantor;
		this.grantee = grantee;
		this.vesting = vesting;
		this.instaBookPage = instaBookPage;
		this.datedDate = datedDate;
		this.recorderdDate = recorderdDate;
		this.comments = comments;
		this.indicator = indicator;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getConsiderationAmount() {
		return considerationAmount;
	}
	public void setConsiderationAmount(String considerationAmount) {
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
	public String getInstaBookPage() {
		return instaBookPage;
	}
	public void setInstaBookPage(String instaBookPage) {
		this.instaBookPage = instaBookPage;
	}
	public Date getDatedDate() {
		return datedDate;
	}
	public void setDatedDate(Date datedDate) {
		this.datedDate = datedDate;
	}
	public Date getRecorderdDate() {
		return recorderdDate;
	}
	public void setRecorderdDate(Date recorderdDate) {
		this.recorderdDate = recorderdDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getIndicator() {
		return indicator;
	}
	public void setIndicator(Integer indicator) {
		this.indicator = indicator;
	}
	public VestingDeedInfo() {
		super();
	}
    
    
    

    
	
}

