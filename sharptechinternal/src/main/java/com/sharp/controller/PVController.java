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
import com.sharp.service.PropertyInfoService;

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
	    @Autowired
	    private PropertyInfoService propertyInfoService;
	    @PostMapping("/update/das")
	    public ResponseEntity<PropertyInfo> updatePropertyInfo(@RequestBody PVRequest pvRequest) {
	        // Retrieve the existing property info by order number
	    	 System.out.println("Received request: " + pvRequest);
	        PropertyInfo existingPropertyInfo = propertyInfoService.findByOrderNumber(pvRequest.getPropertyinfo().getOrderNumber());
	        if (existingPropertyInfo == null) {
	            return ResponseEntity.notFound().build();
	        }

	        // Update the existing PropertyInfo with the new data from pvRequest
	        existingPropertyInfo.setReferenceNumber(pvRequest.getPropertyinfo().getReferenceNumber());
	        existingPropertyInfo.setSearchDate(pvRequest.getPropertyinfo().getSearchDate());
	        existingPropertyInfo.setEffectiveDate(pvRequest.getPropertyinfo().getEffectiveDate());
	        existingPropertyInfo.setPropertyAddress(pvRequest.getPropertyinfo().getPropertyAddress());
	        existingPropertyInfo.setState(pvRequest.getPropertyinfo().getState());
	        existingPropertyInfo.setCounty(pvRequest.getPropertyinfo().getCounty());
	        existingPropertyInfo.setBorrowerName(pvRequest.getPropertyinfo().getBorrowerName());
	        existingPropertyInfo.setLotUnit(pvRequest.getPropertyinfo().getLotUnit());
	        existingPropertyInfo.setBlock(pvRequest.getPropertyinfo().getBlock());
	        existingPropertyInfo.setSubdivision(pvRequest.getPropertyinfo().getSubdivision());
	        existingPropertyInfo.setParcelNumber(pvRequest.getPropertyinfo().getParcelNumber());
	        existingPropertyInfo.setPropertyType(pvRequest.getPropertyinfo().getPropertyType());

	        // Update the related entities
	        existingPropertyInfo.setVestingdeedinfo(pvRequest.getVestingdeedinfo());
	        existingPropertyInfo.setAbsActiveJudgementsAndLines(pvRequest.getPropertyinfo().getAbsActiveJudgementsAndLines());
	        existingPropertyInfo.setAbsopenmortgagedeedinfo(pvRequest.getPropertyinfo().getAbsopenmortgagedeedinfo());
	        existingPropertyInfo.setAssessementsAndTaxInfo(pvRequest.getPropertyinfo().getAssessementsAndTaxInfo());
	        existingPropertyInfo.setNamesrun(pvRequest.getPropertyinfo().getNamesrun());
	        existingPropertyInfo.setTaxinstallments(pvRequest.getPropertyinfo().getTaxinstallments());
	        existingPropertyInfo.setDasadditionalinformation(pvRequest.getPropertyinfo().getDasadditionalinformation());

	        // Save the updated property info
	        PropertyInfo updatedPropertyInfo = propertyInfoService.savePropertyInfo(existingPropertyInfo);

	        // Return the updated property info
	        return ResponseEntity.ok(updatedPropertyInfo);
	    }
	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

