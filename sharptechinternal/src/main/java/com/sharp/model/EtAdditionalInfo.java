package com.sharp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etadditionalinformation")
public class EtAdditionalInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slno;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String additionalInformation;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String additionalInfo;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	


}
