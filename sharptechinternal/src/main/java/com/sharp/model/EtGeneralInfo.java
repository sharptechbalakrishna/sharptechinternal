package com.sharp.model;



import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "etgeneralinfo")
public class EtGeneralInfo {
	
	
	@Id
	private String orderNumber;
	private String refeenceNumber;
	private Date searchDate;
	private Date effectiveDate;
	private String propertyAdderess;
	private String state;
	private String country;
	private String parcelNumber;
    private String subDivision;
    private String lotUnit;
    private String block;
    private String sfrPudCondo;
    
	@Lob
    @Column(name = "document", columnDefinition="BLOB")
    private byte[] document;
	
	@OneToMany(targetEntity = EtVestingInfo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderNumber", referencedColumnName="orderNumber")
	private List<EtVestingInfo> etvestinginfo;
	
	@OneToMany(targetEntity = EtOpenMortageDeedInfo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderNumber", referencedColumnName="orderNumber")
	private List<EtOpenMortageDeedInfo> etopenmortagedeedinfo;
	
	@OneToMany(targetEntity = EtActiveJudgmentsAndLiens.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderNumber", referencedColumnName="orderNumber")
	private List<EtActiveJudgmentsAndLiens> etactivejudgmentsandliens;
	
	@OneToMany(targetEntity = EtTaxInformation.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderNumber", referencedColumnName="orderNumber")
	private List<EtTaxInformation> ettaxinformation;
	
	@OneToMany(targetEntity = EtNameRuns.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderNumber", referencedColumnName="orderNumber")
	private List<EtNameRuns> etnameruns;
	
	@OneToMany(targetEntity = EtTaxInstallment.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderNumber", referencedColumnName="orderNumber")
	private List<EtTaxInstallment> ettaxinstallment;

	
	
	
	
	public EtGeneralInfo() {
		super();
	}

	public EtGeneralInfo(String orderNumber, String refeenceNumber, Date searchDate, Date effectiveDate,
			String propertyAdderess, String state, String country, String parcelNumber, String subDivision,
			String lotUnit, String block, String sfrPudCondo, byte[] document, List<EtVestingInfo> etvestinginfo,
			List<EtOpenMortageDeedInfo> etopenmortagedeedinfo,
			List<EtActiveJudgmentsAndLiens> etactivejudgmentsandliens, List<EtTaxInformation> ettaxinformation,
			List<EtNameRuns> etnameruns, List<EtTaxInstallment> ettaxinstallment) {
		super();
		this.orderNumber = orderNumber;
		this.refeenceNumber = refeenceNumber;
		this.searchDate = searchDate;
		this.effectiveDate = effectiveDate;
		this.propertyAdderess = propertyAdderess;
		this.state = state;
		this.country = country;
		this.parcelNumber = parcelNumber;
		this.subDivision = subDivision;
		this.lotUnit = lotUnit;
		this.block = block;
		this.sfrPudCondo = sfrPudCondo;
		this.document = document;
		this.etvestinginfo = etvestinginfo;
		this.etopenmortagedeedinfo = etopenmortagedeedinfo;
		this.etactivejudgmentsandliens = etactivejudgmentsandliens;
		this.ettaxinformation = ettaxinformation;
		this.etnameruns = etnameruns;
		this.ettaxinstallment = ettaxinstallment;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRefeenceNumber() {
		return refeenceNumber;
	}

	public void setRefeenceNumber(String refeenceNumber) {
		this.refeenceNumber = refeenceNumber;
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getPropertyAdderess() {
		return propertyAdderess;
	}

	public void setPropertyAdderess(String propertyAdderess) {
		this.propertyAdderess = propertyAdderess;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getParcelNumber() {
		return parcelNumber;
	}

	public void setParcelNumber(String parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

	public String getSubDivision() {
		return subDivision;
	}

	public void setSubDivision(String subDivision) {
		this.subDivision = subDivision;
	}

	public String getLotUnit() {
		return lotUnit;
	}

	public void setLotUnit(String lotUnit) {
		this.lotUnit = lotUnit;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getSfrPudCondo() {
		return sfrPudCondo;
	}

	public void setSfrPudCondo(String sfrPudCondo) {
		this.sfrPudCondo = sfrPudCondo;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public List<EtVestingInfo> getEtvestinginfo() {
		return etvestinginfo;
	}

	public void setEtvestinginfo(List<EtVestingInfo> etvestinginfo) {
		this.etvestinginfo = etvestinginfo;
	}

	public List<EtOpenMortageDeedInfo> getEtopenmortagedeedinfo() {
		return etopenmortagedeedinfo;
	}

	public void setEtopenmortagedeedinfo(List<EtOpenMortageDeedInfo> etopenmortagedeedinfo) {
		this.etopenmortagedeedinfo = etopenmortagedeedinfo;
	}

	public List<EtActiveJudgmentsAndLiens> getEtactivejudgmentsandliens() {
		return etactivejudgmentsandliens;
	}

	public void setEtactivejudgmentsandliens(List<EtActiveJudgmentsAndLiens> etactivejudgmentsandliens) {
		this.etactivejudgmentsandliens = etactivejudgmentsandliens;
	}

	public List<EtTaxInformation> getEttaxinformation() {
		return ettaxinformation;
	}

	public void setEttaxinformation(List<EtTaxInformation> ettaxinformation) {
		this.ettaxinformation = ettaxinformation;
	}

	public List<EtNameRuns> getEtnameruns() {
		return etnameruns;
	}

	public void setEtnameruns(List<EtNameRuns> etnameruns) {
		this.etnameruns = etnameruns;
	}

	public List<EtTaxInstallment> getEttaxinstallment() {
		return ettaxinstallment;
	}

	public void setEttaxinstallment(List<EtTaxInstallment> ettaxinstallment) {
		this.ettaxinstallment = ettaxinstallment;
	}

	
	
	}