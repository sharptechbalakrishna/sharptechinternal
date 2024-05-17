package com.sharp.dto;

import java.util.List;

import com.sharp.model.EtGeneralInfo;
import com.sharp.model.EtVestingInfo;

public class EtRequest {
	
	
	private EtGeneralInfo etgeneralinfo;
	private List<EtVestingInfo> etvestinginfo;

	
	public EtGeneralInfo getEtgeneralinfo() {
		return etgeneralinfo;
	}
	public void setEtgeneralinfo(EtGeneralInfo etgeneralinfo) {
		this.etgeneralinfo = etgeneralinfo;
	}
	public List<EtVestingInfo> getEtvestinginfo() {
		return etvestinginfo;
	}
	public void setEtvestinginfo(List<EtVestingInfo> etvestinginfo) {
		this.etvestinginfo = etvestinginfo;
	}

	


}
