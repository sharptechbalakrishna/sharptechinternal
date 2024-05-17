package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "etopenmortagedeedinfo")
public class EtOpenMortageDeedInfo {
	
	
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String mortgago;
	private String mortgagee;
	private String trustee;;
	private String instBookPage;
	private String amount;
    private Date datedDate;
    private Date recordedDate;
    private Date maturityDate;
    private String mortageAssiTo;
    private Long assiBkPg;
    private Date assiDated;
    private String assiRecorded;
    private String additionalInformation;
    private Integer indicator;
    
    
    
	public EtOpenMortageDeedInfo() {
		super();
	}
	public EtOpenMortageDeedInfo(Long slNo, String mortgago, String mortgagee, String trustee, String instBookPage,
			String amount, Date datedDate, Date recordedDate, Date maturityDate, String mortageAssiTo, Long assiBkPg,
			Date assiDated, String assiRecorded, String additionalInformation, Integer indicator) {
		super();
		this.slNo = slNo;
		this.mortgago = mortgago;
		this.mortgagee = mortgagee;
		this.trustee = trustee;
		this.instBookPage = instBookPage;
		this.amount = amount;
		this.datedDate = datedDate;
		this.recordedDate = recordedDate;
		this.maturityDate = maturityDate;
		this.mortageAssiTo = mortageAssiTo;
		this.assiBkPg = assiBkPg;
		this.assiDated = assiDated;
		this.assiRecorded = assiRecorded;
		this.additionalInformation = additionalInformation;
		this.indicator = indicator;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getMortgago() {
		return mortgago;
	}
	public void setMortgago(String mortgago) {
		this.mortgago = mortgago;
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
	public String getInstBookPage() {
		return instBookPage;
	}
	public void setInstBookPage(String instBookPage) {
		this.instBookPage = instBookPage;
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
	public String getMortageAssiTo() {
		return mortageAssiTo;
	}
	public void setMortageAssiTo(String mortageAssiTo) {
		this.mortageAssiTo = mortageAssiTo;
	}
	public Long getAssiBkPg() {
		return assiBkPg;
	}
	public void setAssiBkPg(Long assiBkPg) {
		this.assiBkPg = assiBkPg;
	}
	public Date getAssiDated() {
		return assiDated;
	}
	public void setAssiDated(Date assiDated) {
		this.assiDated = assiDated;
	}
	public String getAssiRecorded() {
		return assiRecorded;
	}
	public void setAssiRecorded(String assiRecorded) {
		this.assiRecorded = assiRecorded;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public Integer getIndicator() {
		return indicator;
	}
	public void setIndicator(Integer indicator) {
		this.indicator = indicator;
	}
    
    
    

}
