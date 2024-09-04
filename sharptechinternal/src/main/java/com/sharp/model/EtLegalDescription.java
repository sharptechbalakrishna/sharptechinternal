package com.sharp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etlegaldescriptioninfo")

public class EtLegalDescription {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slno;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String legaldescription;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getLegaldescription() {
		return legaldescription;
	}

	public void setLegaldescription(String legaldescription) {
		this.legaldescription = legaldescription;
	}
	
	
}
