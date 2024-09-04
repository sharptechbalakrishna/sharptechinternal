package com.sharp.dto;



import java.util.List;

import com.sharp.model.PropertyInfo;
import com.sharp.model.VestingDeedInfo;
import com.sharp.model.AbsActiveJudgementsAndLines;
import com.sharp.model.AssessementsAndTaxInfo;
import com.sharp.model.DasAdditionalInfo;
import com.sharp.model.NamesRun;
import com.sharp.model.OpenMortgageDeddInfo;
import com.sharp.model.TaxInfo;

public class PVRequest {
    
    private PropertyInfo propertyinfo;
    private List<VestingDeedInfo> vestingdeedinfo;
    private List<OpenMortgageDeddInfo> absopenmortgagedeedinfo;
    private List<AbsActiveJudgementsAndLines> absActiveJudgementsAndLines;
    private List<AssessementsAndTaxInfo> assessementsAndTaxInfo;
    private List<NamesRun> namesrun;
    private List<TaxInfo> taxinstallments;
    private List<DasAdditionalInfo> dasadditionalinformation;

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
}

