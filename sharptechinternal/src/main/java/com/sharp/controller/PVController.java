package com.sharp.controller;

import java.util.Optional;
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
	    
	    
//	    @GetMapping("/display/byAddress/{propertyAddress}")
//		public ResponseEntity<List<PropertyInfo>> etDisplayByPropertyAddressWithChildDetails(@PathVariable String propertyAddress) {
//		    List<PropertyInfo> generalInfoListWithVestingInfo = propertyinforepository.findByPropertyAddressWithVestingInfo(propertyAddress);
//		    List<PropertyInfo> generalInfoListWithOpenMortageDeedInfo = propertyinforepository.findByPropertyAddressWithOpenMortageDeedInfo(propertyAddress);
//		    
//		    // Merge or process the lists of results as needed
//		    
//		    List<EtGeneralInfo> mergedList = mergeLists(generalInfoListWithVestingInfo, generalInfoListWithOpenMortageDeedInfo);
//		    
//		    return ResponseEntity.status(HttpStatus.OK).body(mergedList);
//		}
	
	//return userRepository.findById(empId)
	//.orElseThrow(()->new UserNotFoundException(empId));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/insert")
//	public ETGeneralInfo insert(@RequestBody EtRequest request) {
//	    // Save etgeneralinfo
//	    ETGeneralInfo savedGeneralInfo = etgeneralinforepository.save(request.getEtgeneralinfo());
//	    
//	    // Save etvestinginfo
//	    List<EtVestingInfo> vestingInfoList = request.getEtvestinginfo();
//	    if (vestingInfoList != null && !vestingInfoList.isEmpty()) {
//	        for (EtVestingInfo vestingInfo : vestingInfoList) {
//	            vestingInfo.setGeneralInfo(savedGeneralInfo); // Set the reference to etgeneralinfo
//	            etvestinginforepository.save(vestingInfo);
//	        }
//	    }
//	    
//	    return savedGeneralInfo;
//	}
	
	
	
//	@PostMapping("/insert")
//    public void insertEtGeneralInfoAndVestingInfo(@RequestBody EtGeneralInfoAndVestingInfoRequest request) {
//        // Save EtGeneralInfo
//        ETGeneralInfo etGeneralInfo = request.getEtGeneralInfo();
//        String orderNumber = etGeneralInfo.getOrderNumber();
//        System.out.println("Order Number from EtGeneralInfo: " + orderNumber);
//        etGeneralInfo.setOrderNumber(orderNumber);
//        etgeneralinforepository.save(etGeneralInfo);
//
//        // Save EtVestingInfo
//        List<EtVestingInfo> etVestingInfoList = request.getEtVestingInfoList();
//        for (EtVestingInfo etVestingInfo : etVestingInfoList) {
//            etVestingInfo.setETGeneralInfo(etGeneralInfo); // Set the relationship
// //           System.out.println("Order Number set in EtVestingInfo: " + etVestingInfo.getOrderNumber());
//           
//            etvestinginforepository.save(etVestingInfo);
//        }
//    }

}
