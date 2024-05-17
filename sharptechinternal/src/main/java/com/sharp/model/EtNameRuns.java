package com.sharp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="etnameruns")
public class EtNameRuns {
	
	
	@Id
	@GeneratedValue
	private Long slNo;
	private String Name;
	
	
	
	public EtNameRuns() {
		super();
	}
	public EtNameRuns(Long slNo, String name) {
		super();
		this.slNo = slNo;
		Name = name;
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	

}
