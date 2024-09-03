package com.sharp.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.dto.AddressDTO;
import com.sharp.dto.DasAddressDto;
import com.sharp.dto.PVRequest;
import com.sharp.model.EtGeneralInfo;
import com.sharp.model.PropertyInfo;
import com.sharp.repository.PropertyInfoRepository;
import com.sharp.repository.VestingDeedInfoRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class PVController {

	//author updated
	@Autowired
	private PropertyInfoRepository propertyinforepository;
	
	@Autowired
	private VestingDeedInfoRepository vestingdeedinforepository;
	
	

	
	@PostMapping("/insert")
	public  PropertyInfo insert(@RequestBody PVRequest request) {
		
		return propertyinforepository.save(request.getPropertyinfo());
	}
	@GetMapping("/fetch/{orderNumber}")
	public Optional<PropertyInfo> fetch(@PathVariable String orderNumber) {
		return propertyinforepository.findById(orderNumber);
			//	.orElseThrow()->new UserNotFoundException(null)
	}
	
//	@GetMapping("/search/{propertyAddress}")
//	public Optional<PropertyInfo> searchchByAddress(@PathVariable String propertyAddress) {
//		return propertyinforepository.findById(propertyAddress);
//			//	.orElseThrow()->new UserNotFoundException(null)
//	}
//	
//	@GetMapping("/search/{propertyAddress}")
//	public ResponseEntity<List<PropertyInfo>> displayByPropertyAddressWithChildDetails(@PathVariable String propertyAddress) {
//	    List<PropertyInfo> generalInfoListWithVestingInfo = propertyinforepository.findByPropertyAddressWithVestingInfo(propertyAddress);
//	    List<PropertyInfo> generalInfoListWithOpenMortageDeedInfo = propertyinforepository.findByPropertyAddressWithOpenMortageDeedInfo(propertyAddress);
//	    
//	    // Merge or process the lists of results as needed
//	    
//	    List<PropertyInfo> mergedList = mergeLists(generalInfoListWithVestingInfo, generalInfoListWithOpenMortageDeedInfo);
//	    
//	    return ResponseEntity.status(HttpStatus.OK).body(mergedList);
//	}
//
//	private List<PropertyInfo> mergeLists(List<PropertyInfo> list1, List<PropertyInfo> list2) {
//	    List<PropertyInfo> mergedList = new ArrayList<>();
//	    mergedList.addAll(list1);	
//	    return mergedList;
//	}
	
	
	
	 public PVController(PropertyInfoRepository propertyinforepository) {
	        this.propertyinforepository = propertyinforepository;
	    }

	    @GetMapping("/search/{propertyAddress}")
	    public ResponseEntity<List<PropertyInfo>> displayByPropertyAddressWithChildDetails(@PathVariable String propertyAddress) {
	        List<PropertyInfo> generalInfoListWithVestingInfo = propertyinforepository.findByPropertyAddressWithVestingInfo(propertyAddress);
	        List<PropertyInfo> generalInfoListWithOpenMortgageDeedInfo = propertyinforepository.findByPropertyAddressWithOpenMortgageDeedInfo(propertyAddress);
	        
	        // Merge or process the lists of results as needed
	        List<PropertyInfo> mergedList = mergeLists(generalInfoListWithVestingInfo, generalInfoListWithOpenMortgageDeedInfo);
	        
	        return ResponseEntity.status(HttpStatus.OK).body(mergedList);
	    }

	    private List<PropertyInfo> mergeLists(List<PropertyInfo> list1, List<PropertyInfo> list2) {
	        // Merge or process the lists of results as needed
	        // For now, just return the first list
	        return list1;
	    }
	    @Autowired
	    private PropertyInfoRepository propertyInfoRepository;

	    @GetMapping("/partial/Addresssearch/{propertyAddress}")
	    public List<DasAddressDto> searchPropertyAddresses(@PathVariable String propertyAddress) {
	        List<PropertyInfo> generalInfoList = propertyinforepository.searchByAddress(propertyAddress);
	        List<DasAddressDto> addressDTOList = new ArrayList<>();

	        if (generalInfoList.isEmpty()) {
	            // No addresses found
	            DasAddressDto noAddressFound = new DasAddressDto();
	            noAddressFound.setPropertyAddress("No addresses found for: " + propertyAddress);
	            addressDTOList.add(noAddressFound);
	        } else {
	            // Addresses found
	            for (PropertyInfo info : generalInfoList) {
	                DasAddressDto dto = new DasAddressDto();
	                dto.setPropertyAddress(info.getPropertyAddress());
	                dto.setOrderNumber(info.getOrderNumber());
	                addressDTOList.add(dto);
	            }
	        }

	        return addressDTOList;
	    }

//	    @PutMapping("/update")
//	    public PropertyInfo updatePropertyInfo(@RequestBody PVRequest request) {
//	        PropertyInfo propertyInfo = request.getPropertyinfo();
//	        
//	        // Check if the PropertyInfo exists
//	        PropertyInfo existingPropertyInfo = propertyInfoRepository.findById(propertyInfo.getOrderNumber())
//	                .orElseThrow(() -> new ResourceNotFoundException("PropertyInfo not found with orderNumber: " + propertyInfo.getOrderNumber()));
//
//	        // Update existingPropertyInfo with new values from the request
//	        existingPropertyInfo.setReferenceNumber(propertyInfo.getReferenceNumber());
//	        existingPropertyInfo.setSearchDate(propertyInfo.getSearchDate());
//	        existingPropertyInfo.setEffectiveDate(propertyInfo.getEffectiveDate());
//	        existingPropertyInfo.setPropertyAddress(propertyInfo.getPropertyAddress());
//	        existingPropertyInfo.setState(propertyInfo.getState());
//	        existingPropertyInfo.setCounty(propertyInfo.getCounty());
//	        existingPropertyInfo.setBorrowerName(propertyInfo.getBorrowerName());
//	        existingPropertyInfo.setLotUnit(propertyInfo.getLotUnit());
//	        existingPropertyInfo.setBlock(propertyInfo.getBlock());
//	        existingPropertyInfo.setSubdivision(propertyInfo.getSubdivision());
//	        existingPropertyInfo.setParcelNumber(propertyInfo.getParcelNumber());
//	        existingPropertyInfo.setPropertyType(propertyInfo.getPropertyType());
//
//	        // Handle the related entities similarly
//	        existingPropertyInfo.setVestingdeedinfo(propertyInfo.getVestingdeedinfo());
//	        existingPropertyInfo.setAbsActiveJudgementsAndLines(propertyInfo.getAbsActiveJudgementsAndLines());
//	        existingPropertyInfo.setAbsopenmortgagedeedinfo(propertyInfo.getAbsopenmortgagedeedinfo());
//	        existingPropertyInfo.setAssessementsAndTaxInfo(propertyInfo.getAssessementsAndTaxInfo());
//	        existingPropertyInfo.setNamesrun(propertyInfo.getNamesrun());
//	        existingPropertyInfo.setTaxinstallments(propertyInfo.getTaxinstallments());
//	        existingPropertyInfo.setDasadditionalinformation(propertyInfo.getDasadditionalinformation());
//
//	        // Save and return the updated entity
//	        return propertyInfoRepository.save(existingPropertyInfo);
//	    }
	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

