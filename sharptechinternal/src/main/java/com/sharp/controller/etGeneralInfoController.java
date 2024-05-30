package com.sharp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.dto.AddressDTO;
import com.sharp.dto.EtRequest;
import com.sharp.model.EtGeneralInfo;
import com.sharp.repository.EtGeneralInfoRepository;
import com.sharp.repository.EtTaxInformationRepositroy;
import com.sharp.repository.EtVestingInfoRepository;


// This is another Comment
@RestController
@CrossOrigin("http://localhost:3000")
public class etGeneralInfoController {

	
	@Autowired
	private EtGeneralInfoRepository etgeneralinforepository;
	
	@Autowired
	private EtVestingInfoRepository etvestinginforepository;
	
	@Autowired
	private EtTaxInformationRepositroy etraxinformationrepositroy;
	

	
	@PostMapping("/etinsert")
	public  EtGeneralInfo insert(@RequestBody EtRequest request) {
		
		return etgeneralinforepository.save(request.getEtgeneralinfo());
	}
	
	

	
	@GetMapping("/display/{orderNumber}") 
	public EtGeneralInfo displayByOrderNumber(@PathVariable String orderNumber) {
		
		return etgeneralinforepository.findByOrderNumber(orderNumber);
	}
	
	@GetMapping("/display/byAddress/{propertyAddress}")
	public ResponseEntity<List<EtGeneralInfo>> etDisplayByPropertyAddressWithChildDetails(@PathVariable String propertyAddress) {
	    List<EtGeneralInfo> generalInfoListWithVestingInfo = etgeneralinforepository.findByPropertyAddressWithVestingInfo(propertyAddress);
	    List<EtGeneralInfo> generalInfoListWithOpenMortageDeedInfo = etgeneralinforepository.findByPropertyAddressWithOpenMortageDeedInfo(propertyAddress);
	    
	    // Merge or process the lists of results as needed
	    
	    List<EtGeneralInfo> mergedList = mergeLists(generalInfoListWithVestingInfo, generalInfoListWithOpenMortageDeedInfo);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(mergedList);
	}
	
	

	private List<EtGeneralInfo> mergeLists(List<EtGeneralInfo> list1, List<EtGeneralInfo> list2) {
	    List<EtGeneralInfo> mergedList = new ArrayList<>();
	    mergedList.addAll(list1);	
	    return mergedList;
	}
	
	@GetMapping("/partial/search/{propertyAddress}")
	public List<AddressDTO> searchPropertyAddresses(@PathVariable String propertyAddress) {
	    List<EtGeneralInfo> generalInfoList = etgeneralinforepository.searchByAddress(propertyAddress);
	    List<AddressDTO> addressDTOList = new ArrayList<>();
	    
	    if (generalInfoList.isEmpty()) {
	        // No addresses found
	        AddressDTO noAddressFound = new AddressDTO();
	        noAddressFound.setAddress("No addresses found for: " + propertyAddress);
	        addressDTOList.add(noAddressFound);
	    } else {
	        // Addresses found
	        for (EtGeneralInfo info : generalInfoList) {
	            AddressDTO dto = new AddressDTO();
	            dto.setAddress(info.getPropertyAdderess());
	            dto.setOrderNumber(info.getOrderNumber());
	            addressDTOList.add(dto);
	        }
	    }

	    return addressDTOList;
	}	
//	@GetMapping("/partial/search/{propertyAddress}")
//	public List<EtGeneralInfo> searchByAddress(@PathVariable String propertyAddress) {
//	    return etgeneralinforepository.searchByAddress(propertyAddress);
//	}
//	
	

}
