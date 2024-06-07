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
	private String jud;
	private String liens;
	private String ucc;
	private String others;
	
	
	
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
