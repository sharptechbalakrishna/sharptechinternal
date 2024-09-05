package com.sharp.dto;



import java.sql.Date;
import java.util.List;

import com.sharp.model.PropertyInfo;
import com.sharp.model.VestingDeedInfo;
import com.sharp.model.AbsActiveJudgementsAndLines;
import com.sharp.model.AssessementsAndTaxInfo;
import com.sharp.model.DasAdditionalInfo;
import com.sharp.model.DasLegalDescription;
import com.sharp.model.NamesRun;
import com.sharp.model.OpenMortgageDeddInfo;
import com.sharp.model.TaxInfo;

public class PVRequest {
    
    private PropertyInfo propertyinfo;
    private String orderNumber;	
	private String referenceNumber;
	private Date searchDate;
	private Date effectiveDate;
	private String propertyAddress;	
	private String state;	
	private String county;
	private String borrowerName;
	private String lotUnit;	
	private String block;	
	private String subdivision;	
	private String parcelNumber;
	private String propertyType;
    private List<VestingDeedInfo> vestingdeedinfo;
    private List<OpenMortgageDeddInfo> absopenmortgagedeedinfo;
    private List<AbsActiveJudgementsAndLines> absActiveJudgementsAndLines;
    private List<AssessementsAndTaxInfo> assessementsAndTaxInfo;
    private List<NamesRun> namesrun;
    private List<TaxInfo> taxinstallments;
    private List<DasAdditionalInfo> dasadditionalinformation;
    private List<DasLegalDescription> daslegaldescriptioninfo;
    public List<DasLegalDescription> getDaslegaldescriptioninfo() {
		return daslegaldescriptioninfo;
	}

	public void setDaslegaldescriptioninfo(List<DasLegalDescription> daslegaldescriptioninfo) {
		this.daslegaldescriptioninfo = daslegaldescriptioninfo;
	}

	public PropertyInfo getPropertyinfo() {
        return propertyinfo;        
    }

    public void setPropertyinfo(PropertyInfo propertyinfo) {
        this.propertyinfo = propertyinfo;
    }

    public List<VestingDeedInfo> getVestingdeedinfo() {
        return vestingdeedinfo;
    }

    public void setVestingdeedinfo(List<VestingDeedInfo> vestingdeedinfo) {
        this.vestingdeedinfo = vestingdeedinfo;
    }

    public List<OpenMortgageDeddInfo> getAbsopenmortgagedeedinfo() {
        return absopenmortgagedeedinfo;
    }

    public void setAbsopenmortgagedeedinfo(List<OpenMortgageDeddInfo> absopenmortgagedeedinfo) {
        this.absopenmortgagedeedinfo = absopenmortgagedeedinfo;
    }

    public List<AbsActiveJudgementsAndLines> getAbsActiveJudgementsAndLines() {
        return absActiveJudgementsAndLines;
    }

    public void setAbsActiveJudgementsAndLines(List<AbsActiveJudgementsAndLines> absActiveJudgementsAndLines) {
        this.absActiveJudgementsAndLines = absActiveJudgementsAndLines;
    }

    public List<AssessementsAndTaxInfo> getAssessementsAndTaxInfo() {
        return assessementsAndTaxInfo;
    }

    public void setAssessementsAndTaxInfo(List<AssessementsAndTaxInfo> assessementsAndTaxInfo) {
        this.assessementsAndTaxInfo = assessementsAndTaxInfo;
    }

    public List<NamesRun> getNamesrun() {
        return namesrun;
    }

    public void setNamesrun(List<NamesRun> namesrun) {
        this.namesrun = namesrun;
    }

    public List<TaxInfo> getTaxinstallments() {
        return taxinstallments;
    }

    public void setTaxinstallments(List<TaxInfo> taxinstallments) {
        this.taxinstallments = taxinstallments;
    }

    public List<DasAdditionalInfo> getDasadditionalinformation() {
        return dasadditionalinformation;
    }

    public void setDasadditionalinformation(List<DasAdditionalInfo> dasadditionalinformation) {
        this.dasadditionalinformation = dasadditionalinformation;
    }

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
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

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
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

	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getParcelNumber() {
		return parcelNumber;
	}

	public void setParcelNumber(String parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
    
}

