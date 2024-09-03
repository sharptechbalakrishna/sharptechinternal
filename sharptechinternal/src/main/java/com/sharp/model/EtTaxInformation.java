package com.sharp.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ettaxinformation")
public class EtTaxInformation {
	
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String landValue;
	public String assementYear;
	public String taxYear;
	private String buildingValue;
	private String totalValue;
	private String excemption;
	private String notes;
	
	
	
	
	public EtTaxInformation() {
		super();
	}
	
	public EtTaxInformation(Long slNo, String landValue, String buildingValue, String totalValue, String excemption,
			String notes,String assementYear, String taxYear) {
		super();
		this.slNo = slNo;
		this.landValue = landValue;
		this.buildingValue = buildingValue;
		this.totalValue = totalValue;
		this.excemption = excemption;
		this.notes = notes;
		this.assementYear = assementYear;
		this.taxYear = taxYear;
	}
	
	
	public String getAssementYear() {
		return assementYear;
	}
	public void setAssementYear(String assementYear) {
		this.assementYear = assementYear;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getLandValue() {
		return landValue;
	}
	public void setLandValue(String landValue) {
		this.landValue = landValue;
	}
	public String getBuildingValue() {
		return buildingValue;
	}
	public void setBuildingValue(String buildingValue) {
		this.buildingValue = buildingValue;
	}
	public String getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
	public String getExcemption() {
		return excemption;
	}
	public void setExcemption(String excemption) {
		this.excemption = excemption;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		
	}
	
	
}
