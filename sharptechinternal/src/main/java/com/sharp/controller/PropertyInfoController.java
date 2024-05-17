//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dto.AbRequest;
//import com.example.demo.model.PropertyInfo;
//import com.example.demo.repository.PropertyInfoRepository;
//import com.example.demo.repository.VestingInfoRepository;
// 
//
//
//
//@RestController
////@RequestMapping("property")
//public class PropertyInfoController {
//
//	@Autowired
//	private PropertyInfoRepository propertyInfoRepository;
//	@Autowired
//    private VestingInfoRepository vestingInfoRepository;
//	
//	
//	
////	@PostMapping("save")
////	public ResponseEntity<?> save(@RequestBody PropertyInfo propertyInfo) {
////	    try {
////	        if (propertyInfo == null) {
////	            throw new IllegalArgumentException("PropertyInfo object is null");
////	        }
////	        // Ensure vestingInfo is not null and has at least one element
////	        if (propertyInfo.getVestingInfo() == null || propertyInfo.getVestingInfo().isEmpty()) {
////	            throw new IllegalArgumentException("VestingInfo list is null or empty");
////	        }
////	        PropertyInfo savedPropertyInfo = propertyInfoRepository.save(propertyInfo);
////	        return ResponseEntity.ok(savedPropertyInfo);
////	    } catch (Exception e) {
////	        e.printStackTrace();
////	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving PropertyInfo: " + e.getMessage());
////	    }
////	}
//	
//	
//	
////	@PostMapping("/insert")
////	public PropertyInfo save(@RequestBody AbRequest request) {
////		return propertyInfoRepository.save(request.getPropertyinfo());
////		
////	}
//	
//	
//	
//	
//	
////	 @GetMapping("/{id}")
////	    public ResponseEntity<PropertyInfo> getPropertyInfoById(@PathVariable Long id) {
////	        PropertyInfo propertyInfo = propertyInfoService.getPropertyInfoById(id);
////	        if (propertyInfo != null) {
////	            return ResponseEntity.ok(propertyInfo);
////	        } else {
////	            return ResponseEntity.notFound().build();
////	        }
////	    }
//	 
//	 
////	 @PostMapping("/create")
////	    public ResponseEntity<PropertyInfo> createPropertyInfo(@RequestBody PropertyInfo propertyInfo) {
////	        PropertyInfo createdPropertyInfo = propertyInfoRepository.createPropertyInfo(propertyInfo);
////	        return ResponseEntity.status(HttpStatus.CREATED).body(createdPropertyInfo);
////	    }
//	 
////	 @PostMapping("save")
////	 public PropertyInfo save(@RequestBody PropertyInfo propertyInfo)
////	 {
////		return propertyInfoRepository.save(propertyInfo);
////		 
////	 }
//	
//	 
////	 	@Autowired
////	    private PropertyInfoRepository propertyInfoRepository;
////
////	    @Autowired
////	    private VestingInfoRepository vestingInfoRepository;
////	   
////
////	    @PostMapping("save")
////	    public PropertyInfo save1(@RequestBody PropertyInfo propertyInfo) {
////	        // Save PropertyInfo
////	        PropertyInfo savedPropertyInfo = propertyInfoRepository.save(propertyInfo);
////
////	        // Set the reference to PropertyInfo for each VestingInfo and save
////	        if (propertyInfo.getVestingInfo() != null) {
////	            for (VestingInfo vestingInfo : propertyInfo.getVestingInfo()) {
////	                vestingInfo.setPropertyInfo(savedPropertyInfo);
////	                vestingInfoRepository.save(vestingInfo);
////	            }
////	        }
////
////	        return savedPropertyInfo;
////	    }
//	 
////	@Transactional
////    @PostMapping("save")
////    public PropertyInfo save(@RequestBody PropertyInfo propertyInfo) {
////        PropertyInfo savedPropertyInfo = propertyInfoRepository.save(propertyInfo);
////
////        for (VestingInfo vestingInfo : propertyInfo.getVestingInfo()) {
////            vestingInfo.setPropertyInfo(savedPropertyInfo);
////            vestingInfoRepository.save(vestingInfo);
////        }
////
////        return savedPropertyInfo;
////    }
//}



