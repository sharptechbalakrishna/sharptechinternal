package com.sharp.model;

import java.sql.Date;
import java.util.List;

public class EtGeneralRequest {
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
	    private List<EtVestingInfo> etvestinginfo;
	    private List<EtOpenMortageDeedInfo> etopenmortagedeedinfo;
	    private List<EtActiveJudgmentsAndLiens> etactivejudgmentsandliens;
	    private List<EtTaxInformation> ettaxinformation;
	    private List<EtNameRuns> etnameruns;
	    private List<EtTaxInstallment> ettaxinstallment;
	    private List<EtAdditionalInfo> etadditionalinformation;
		
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
		public List<EtAdditionalInfo> getEtadditionalinformation() {
			return etadditionalinformation;
		}
		public void setEtadditionalinformation(List<EtAdditionalInfo> etadditionalinformation) {
			this.etadditionalinformation = etadditionalinformation;
		}
	    

}
