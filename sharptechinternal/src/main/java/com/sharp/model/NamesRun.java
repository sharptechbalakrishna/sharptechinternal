package com.sharp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "namesrun")
public class NamesRun {
	@Id
	@GeneratedValue
	private Long slno;
	private String Name;
	private String jud;
	private String liens;
	private String ucc;
	private String others;
	
	
	public NamesRun() {
		super();
	}


	public Long getSlno() {
		return slno;
	}


	public void setSlno(Long slno) {
		this.slno = slno;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getJud() {
		return jud;
	}


	public void setJud(String jud) {
		this.jud = jud;
	}


	public String getLiens() {
		return liens;
	}


	public void setLiens(String liens) {
		this.liens = liens;
	}


	public String getUcc() {
		return ucc;
	}


	public void setUcc(String ucc) {
		this.ucc = ucc;
	}


	public String getOthers() {
		return others;
	}


	public void setOthers(String others) {
		this.others = others;
	}
	
	
	
	
	

}
