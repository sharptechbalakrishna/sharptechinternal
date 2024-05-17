package com.sharp.model;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "table2")
//public class VestingInfo {
//
//	@Id
//	@GeneratedValue
//	private Long slNo;
//
//	public String deedType;
//	public String considerationAmount;
//	public String grantor;
//	public String grantee;
//	public String vestingInfo;
//	public String instaBookPage;
//	public Date datedDate;
//	public Date recorderdDate;
//	public String comments;
//
////	@ManyToOne
////	//@JoinColumn(name = "slNo", nullable = false)
////	private PropertyInfo propertyInfo;
//
//	//, PropertyInfo propertyInfo
//
//	public VestingInfo() {
//		super();
//	}
//
//	public VestingInfo(Long slNo, String orderNumber, String deedType, String considerationAmount, String grantor,
//			String grantee, String vestingInfo, String instaBookPage, Date datedDate, Date recorderdDate,
//			String comments) {
//		super();
//		this.slNo = slNo;
//		
//		this.deedType = deedType;
//		this.considerationAmount = considerationAmount;
//		this.grantor = grantor;
//		this.grantee = grantee;
//		this.vestingInfo = vestingInfo;
//		this.instaBookPage = instaBookPage;
//		this.datedDate = datedDate;
//		this.recorderdDate = recorderdDate;
//		this.comments = comments;
//	//	this.propertyInfo = propertyInfo;
//	}
//
//	public String getDeedType() {
//		return deedType;
//	}
//
//	public void setDeedType(String deedType) {
//		this.deedType = deedType;
//	}
//
//	public String getConsiderationAmount() {
//		return considerationAmount;
//	}
//
//	public void setConsiderationAmount(String considerationAmount) {
//		this.considerationAmount = considerationAmount;
//	}
//
//	public String getGrantor() {
//		return grantor;
//	}
//
//	public void setGrantor(String grantor) {
//		this.grantor = grantor;
//	}
//
//	public String getGrantee() {
//		return grantee;
//	}
//
//	public void setGrantee(String grantee) {
//		this.grantee = grantee;
//	}
//
//	public String getVestingInfo() {
//		return vestingInfo;
//	}
//
//	public void setVestingInfo(String vestingInfo) {
//		this.vestingInfo = vestingInfo;
//	}
//
//	public String getInstaBookPage() {
//		return instaBookPage;
//	}
//
//	public void setInstaBookPage(String instaBookPage) {
//		this.instaBookPage = instaBookPage;
//	}
//
//	public Date getDatedDate() {
//		return datedDate;
//	}
//
//	public void setDatedDate(Date datedDate) {
//		this.datedDate = datedDate;
//	}
//
//	public Date getRecorderdDate() {
//		return recorderdDate;
//	}
//
//	public void setRecorderdDate(Date recorderdDate) {
//		this.recorderdDate = recorderdDate;
//	}
//
//	public String getComments() {
//		return comments;
//	}
//
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//
//}