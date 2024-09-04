package com.sharp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharp.model.EtGeneralInfo;
import com.sharp.repository.EtGeneralInfoRepository;

@Service
public class EtGeneralInfoService {

    @Autowired
    private EtGeneralInfoRepository etGeneralInfoRepository;

//    @Transactional
//    public EtGeneralInfo updateEtGeneralInfo(String orderNumber, EtGeneralInfo updatedInfo) {
//        // Fetch the existing info from the repository
//        EtGeneralInfo existingInfo = etGeneralInfoRepository.findById(orderNumber)
//                .orElseThrow(() -> new RuntimeException("Order not found: " + orderNumber));
//
//        // Update fields only if they are not null
//        if (updatedInfo.getRefeenceNumber() != null) {
//            existingInfo.setRefeenceNumber(updatedInfo.getRefeenceNumber());
//        }
//        if (updatedInfo.getSearchDate() != null) {
//            existingInfo.setSearchDate(updatedInfo.getSearchDate());
//        }
//        if (updatedInfo.getEffectiveDate() != null) {
//            existingInfo.setEffectiveDate(updatedInfo.getEffectiveDate());
//        }
//        if (updatedInfo.getPropertyAdderess() != null) {
//            existingInfo.setPropertyAdderess(updatedInfo.getPropertyAdderess());
//        }
//        if (updatedInfo.getState() != null) {
//            existingInfo.setState(updatedInfo.getState());
//        }
//        if (updatedInfo.getCountry() != null) {
//            existingInfo.setCountry(updatedInfo.getCountry());
//        }
//        if (updatedInfo.getParcelNumber() != null) {
//            existingInfo.setParcelNumber(updatedInfo.getParcelNumber());
//        }
//        if (updatedInfo.getSubDivision() != null) {
//            existingInfo.setSubDivision(updatedInfo.getSubDivision());
//        }
//        if (updatedInfo.getLotUnit() != null) {
//            existingInfo.setLotUnit(updatedInfo.getLotUnit());
//        }
//        if (updatedInfo.getBlock() != null) {
//            existingInfo.setBlock(updatedInfo.getBlock());
//        }
//        if (updatedInfo.getSfrPudCondo() != null) {
//            existingInfo.setSfrPudCondo(updatedInfo.getSfrPudCondo());
//        }
//        if (updatedInfo.getDocument() != null) {
//            existingInfo.setDocument(updatedInfo.getDocument());
//        }
//
//        // Update collections if provided
//        if (updatedInfo.getEtvestinginfo() != null) {
//            existingInfo.setEtvestinginfo(updatedInfo.getEtvestinginfo());
//        }
//        if (updatedInfo.getEtopenmortagedeedinfo() != null) {
//            existingInfo.setEtopenmortagedeedinfo(updatedInfo.getEtopenmortagedeedinfo());
//        }
//        if (updatedInfo.getEtactivejudgmentsandliens() != null) {
//            existingInfo.setEtactivejudgmentsandliens(updatedInfo.getEtactivejudgmentsandliens());
//        }
//        if (updatedInfo.getEttaxinformation() != null) {
//            existingInfo.setEttaxinformation(updatedInfo.getEttaxinformation());
//        }
//        if (updatedInfo.getEtnameruns() != null) {
//            existingInfo.setEtnameruns(updatedInfo.getEtnameruns());
//        }
//        if (updatedInfo.getEttaxinstallment() != null) {
//            existingInfo.setEttaxinstallment(updatedInfo.getEttaxinstallment());
//        }
//        if (updatedInfo.getEtadditionalinformation() != null) {
//            existingInfo.setEtadditionalinformation(updatedInfo.getEtadditionalinformation());
//        }
//
//        // Save and return the updated entity
//        return etGeneralInfoRepository.save(existingInfo);
//    }
    @Transactional
    public EtGeneralInfo updateEtGeneralInfo(String orderNumber, EtGeneralInfo updatedInfo) {
        EtGeneralInfo existingInfo = etGeneralInfoRepository.findById(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderNumber));
        System.out.println("Existing Info: " + existingInfo);
        // Update logic
        return etGeneralInfoRepository.save(existingInfo);
    }
}
