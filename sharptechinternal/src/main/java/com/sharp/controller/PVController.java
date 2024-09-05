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
//	    @Autowired
//	    private PropertyInfoService propertyInfoService;
//	    
	    @Autowired
	    private PropertyInfoService propertyInfoService;

	    @PostMapping("/update/das")
	    public ResponseEntity<PropertyInfo> updatePropertyInfo(@RequestBody PropertyInfo newPropertyInfo) {
	        // Retrieve the existing property info by order number
	        System.out.println("Received request: " + newPropertyInfo);
	        PropertyInfo existingPropertyInfo = propertyInfoService.findByOrderNumber(newPropertyInfo.getOrderNumber());
	        if (existingPropertyInfo == null) {
	            return ResponseEntity.notFound().build();
	        }

	        // Update fields only if the new value is not null
	        if (newPropertyInfo.getReferenceNumber() != null) {
	            existingPropertyInfo.setReferenceNumber(newPropertyInfo.getReferenceNumber());
	        }
	        if (newPropertyInfo.getSearchDate() != null) {
	            existingPropertyInfo.setSearchDate(newPropertyInfo.getSearchDate());
	        }
	        if (newPropertyInfo.getEffectiveDate() != null) {
	            existingPropertyInfo.setEffectiveDate(newPropertyInfo.getEffectiveDate());
	        }
	        if (newPropertyInfo.getPropertyAddress() != null) {
	            existingPropertyInfo.setPropertyAddress(newPropertyInfo.getPropertyAddress());
	        }
	        if (newPropertyInfo.getState() != null) {
	            existingPropertyInfo.setState(newPropertyInfo.getState());
	        }
	        if (newPropertyInfo.getCounty() != null) {
	            existingPropertyInfo.setCounty(newPropertyInfo.getCounty());
	        }
	        if (newPropertyInfo.getBorrowerName() != null) {
	            existingPropertyInfo.setBorrowerName(newPropertyInfo.getBorrowerName());
	        }
	        if (newPropertyInfo.getLotUnit() != null) {
	            existingPropertyInfo.setLotUnit(newPropertyInfo.getLotUnit());
	        }
	        if (newPropertyInfo.getBlock() != null) {
	            existingPropertyInfo.setBlock(newPropertyInfo.getBlock());
	        }
	        if (newPropertyInfo.getSubdivision() != null) {
	            existingPropertyInfo.setSubdivision(newPropertyInfo.getSubdivision());
	        }
	        if (newPropertyInfo.getParcelNumber() != null) {
	            existingPropertyInfo.setParcelNumber(newPropertyInfo.getParcelNumber());
	        }
	        if (newPropertyInfo.getPropertyType() != null) {
	            existingPropertyInfo.setPropertyType(newPropertyInfo.getPropertyType());
	        }

	        // Update related entities only if the new data is not null
	        if (newPropertyInfo.getVestingdeedinfo() != null) {
	            existingPropertyInfo.setVestingdeedinfo(newPropertyInfo.getVestingdeedinfo());
	        }
	        if (newPropertyInfo.getAbsopenmortgagedeedinfo() != null) {
	            existingPropertyInfo.setAbsopenmortgagedeedinfo(newPropertyInfo.getAbsopenmortgagedeedinfo());
	        }
	        if (newPropertyInfo.getAbsActiveJudgementsAndLines() != null) {
	            existingPropertyInfo.setAbsActiveJudgementsAndLines(newPropertyInfo.getAbsActiveJudgementsAndLines());
	        }
	        if (newPropertyInfo.getAssessementsAndTaxInfo() != null) {
	            existingPropertyInfo.setAssessementsAndTaxInfo(newPropertyInfo.getAssessementsAndTaxInfo());
	        }
	        if (newPropertyInfo.getNamesrun() != null) {
	            existingPropertyInfo.setNamesrun(newPropertyInfo.getNamesrun());
	        }
	        if (newPropertyInfo.getTaxinstallments() != null) {
	            existingPropertyInfo.setTaxinstallments(newPropertyInfo.getTaxinstallments());
	        }
	        if (newPropertyInfo.getDasadditionalinformation() != null) {
	            existingPropertyInfo.setDasadditionalinformation(newPropertyInfo.getDasadditionalinformation());
	        }
	        if (newPropertyInfo.getDaslegaldescriptioninfo() != null) {
	            existingPropertyInfo.setDaslegaldescriptioninfo(newPropertyInfo.getDaslegaldescriptioninfo());
	        }

	        // Save the updated property info
	        PropertyInfo updatedPropertyInfo = propertyInfoService.save(existingPropertyInfo);
	        
	        return ResponseEntity.ok(updatedPropertyInfo);
	    }
	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

