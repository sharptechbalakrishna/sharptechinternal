package com.sharp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import com.sharp.dto.EtInsertResponse;
import com.sharp.dto.EtRequest;
import com.sharp.model.EtGeneralInfo;
import com.sharp.model.EtGeneralRequest;
import com.sharp.repository.EtGeneralInfoRepository;
import com.sharp.repository.EtTaxInformationRepositroy;
import com.sharp.repository.EtVestingInfoRepository;
import com.sharp.service.EtGeneralInfoService;


// This is another Comment
@RestController
@CrossOrigin("http://localhost:3000")
public class EtGeneralInfoController {

	
	@Autowired
	private EtGeneralInfoRepository etgeneralinforepository;
	
	@Autowired
	private EtVestingInfoRepository etvestinginforepository;
	
	@Autowired
	private EtTaxInformationRepositroy etraxinformationrepositroy;
	

	
	public EtGeneralInfoController(EtGeneralInfoRepository etgeneralinforepository) {
        this.etgeneralinforepository = etgeneralinforepository;
    }
 
	
	@PostMapping("/etinsert")
    public ResponseEntity<EtInsertResponse> insert(@RequestBody EtRequest request) {
		EtInsertResponse resp = new EtInsertResponse();
        try {
            String orderNumber = request.getEtgeneralinfo().getOrderNumber();
            Optional<EtGeneralInfo> existingData = etgeneralinforepository.findById(orderNumber);
            
            if (existingData.isPresent()) {
                resp.setMessage("Order number already exists. Data not saved.");
                resp.setStatusCode(400);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
            }

            EtGeneralInfo savedData = etgeneralinforepository.save(request.getEtgeneralinfo());
            if (savedData != null) {
                resp.setData(savedData);
                resp.setMessage("Data stored successfully.");
                resp.setStatusCode(200);
            } else {
                resp.setMessage("Failed to store data.");
                resp.setStatusCode(500);
            }
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setMessage("An error occurred: " + e.getMessage());
            resp.setError(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
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
//	 @PutMapping("/{orderNumber}")
	@Autowired
	private EtGeneralInfoService etGeneralInfoService;
	//@PostMapping("update/etrack")
//	 @PutMapping("/update/{orderNumber}")
//	 public ResponseEntity<EtGeneralInfo> updateEtGeneralInfo(@PathVariable String orderNumber, @RequestBody EtGeneralInfo updateRequest) {
//	        System.out.println("Entered into update request for orderNumber: " + orderNumber);
//	        try {
//	            EtGeneralInfo updatedEtGeneralInfo = etGeneralInfoService.updateEtGeneralInfo(orderNumber, updateRequest);
//	            return ResponseEntity.ok(updatedEtGeneralInfo);
//	        } catch (IllegalArgumentException e) {
//	            return ResponseEntity.badRequest().body(null); // Handle bad requests if input is invalid
//	        } catch (NoSuchElementException e) {
//	            return ResponseEntity.notFound().build(); // Handle case where orderNumber is not found
//	        }
//	    }
	
//	@PutMapping("/update/{orderNumber}")
//	public ResponseEntity<EtGeneralInfo> updateEtGeneralInfo(@PathVariable String orderNumber, @RequestBody EtGeneralInfo updateRequest) {
//	    System.out.println("Order Number: " + orderNumber);
//	    System.out.println("Update Request: " + updateRequest);
//	    try {
//	        EtGeneralInfo updatedEtGeneralInfo = etGeneralInfoService.updateEtGeneralInfo(orderNumber, updateRequest);
//	        return ResponseEntity.ok(updatedEtGeneralInfo);
//	    } catch (IllegalArgumentException e) {
//	        return ResponseEntity.badRequest().body(null);
//	    } catch (NoSuchElementException e) {
//	        return ResponseEntity.notFound().build();
//	    }
//	}
}
