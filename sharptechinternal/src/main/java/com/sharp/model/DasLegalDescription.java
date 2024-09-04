package com.sharp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daslegaldescriptioninfo")
public class DasLegalDescription {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slno;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String daslegaldesc;

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getDaslegaldesc() {
		return daslegaldesc;
	}

	public void setDaslegaldesc(String daslegaldesc) {
		this.daslegaldesc = daslegaldesc;
	}
	
	
}
