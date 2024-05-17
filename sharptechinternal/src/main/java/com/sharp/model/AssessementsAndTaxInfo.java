package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "absassessmentandtaxinfo")
public class AssessementsAndTaxInfo {
	
	@Id
	@GeneratedValue
	private Long slno;
	private Date taxYear;
	private String landValue;
	private String buildingValue;
	private String extraValue;
	private String totalValue;
	private String comments;
	
	
	
	
	public AssessementsAndTaxInfo() {
		super();
	}

	public AssessementsAndTaxInfo(Long slno, Date taxYear, String landValue, String buildingValue, String extraValue,
			String totalValue, String comments) {
		super();
		this.slno = slno;
		this.taxYear = taxYear;
		this.landValue = landValue;
		this.buildingValue = buildingValue;
		this.extraValue = extraValue;
		this.totalValue = totalValue;
		this.comments = comments;
	}

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public Date getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(Date taxYear) {
		this.taxYear = taxYear;
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

	public String getExtraValue() {
		return extraValue;
	}

	public void setExtraValue(String extraValue) {
		this.extraValue = extraValue;
	}

	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}