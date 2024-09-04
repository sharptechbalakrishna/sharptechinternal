package com.sharp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.dto.LogoutRequest;
import com.sharp.dto.OtpVerificationRequest;
import com.sharp.dto.ReqRes;
import com.sharp.dto.UpdatesReqRes;
import com.sharp.model.Employee;
import com.sharp.model.Updates;
import com.sharp.service.EmployeeManagementService;

@RestController
public class EmployeeManagmentController {

	@Autowired
	private EmployeeManagementService employeeManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeManagmentController.class);
	
	
	// Login
	@PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req) {
		System.out.println("Loggin Emai" + req.getEmail());
        return ResponseEntity.ok(employeeManagementService.login(req));
    }
//	@PostMapping("/auth/login")
//    public ResponseEntity<ReqRes> login(@RequestBody ReqRes loginRequest) {
//        ReqRes response = employeeManagementService.login(loginRequest);
//        return ResponseEntity.status(response.getStatusCode()).body(response);
//    }
	
	 @PostMapping("/auth/verify-otp")
	    public ResponseEntity<ReqRes> verifyOtp(@RequestBody OtpVerificationRequest otpRequest) {
		 return ResponseEntity.ok(employeeManagementService.verifyOtp(otpRequest.getEmail(), otpRequest.getOtp()));
	    }
	
	// Logout 
	@PostMapping("/auth/logout")
    public ResponseEntity<ReqRes> logout(@RequestBody LogoutRequest req) {
        logger.info("Logout request received for email: {}", req.getEmail());
        return ResponseEntity.ok(employeeManagementService.logout(req.getEmail(), req.getTransactionId()));
    }
	
	// Admin Register
	@PostMapping("/auth/register")
	public ResponseEntity<ReqRes> regeister(@RequestBody ReqRes reg	
//			, @AuthenticationPrincipal UserDetails adminDetails
			) {
//		String adminEmail = adminDetails.getUsername();
		return ResponseEntity.ok(employeeManagementService.register(reg
//				, adminEmail
				));
	}
	

	
	
//	@GetMapping("/future/updates")
//    public ResponseEntity<UpdatesReqRes> getAllUpdates() {
//        return ResponseEntity.ok(employeeManagementService.getAllUpdates());
//    }
//	
	
	
	@PostMapping("/auth/refresh")
	public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes req) {
		return ResponseEntity.ok(employeeManagementService.refreshToken(req));
	}

	@GetMapping("/admin/get-all-users")
	public ResponseEntity<ReqRes> getAllUsers() {
		return ResponseEntity.ok(employeeManagementService.getAllUsers());

	}

	@GetMapping("/admin/get-users/{userId}")
	public ResponseEntity<ReqRes> getUSerByID(@PathVariable Long userId) {
		return ResponseEntity.ok(employeeManagementService.getUsersById(userId));

	}

	@GetMapping("/admin/get-users-by-empid/{empId}")
	public ResponseEntity<ReqRes> getUserByEmpId(@PathVariable String empId) {
		return ResponseEntity.ok(employeeManagementService.getUsersByEmpId(empId));
	}

	@PutMapping("/admin/update/{userId}")
	public ResponseEntity<ReqRes> updateUser(@PathVariable Long userId, @RequestBody Employee reqres) {
		return ResponseEntity.ok(employeeManagementService.updateUser(userId, reqres));
	}

	@GetMapping("/adminuser/get-profile")
	public ResponseEntity<ReqRes> getMyProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		ReqRes response = employeeManagementService.getMyInfo(email);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}

	@DeleteMapping("/admin/delete/{userId}")
	public ResponseEntity<ReqRes> deleteUSer(@PathVariable Long userId) {
		return ResponseEntity.ok(employeeManagementService.deleteUser(userId));
	}
	
	
	@GetMapping("/future/updates")
    public ResponseEntity<UpdatesReqRes> getAllUpdates() {
        return ResponseEntity.ok(employeeManagementService.getAllUpdates());
    }
	
	
	@PostMapping("/future/updates")
    public ResponseEntity<Updates> createUpdate(@RequestBody UpdatesReqRes updatesReqRes) {
		
		return ResponseEntity.ok(employeeManagementService.saveUpdate(updatesReqRes));
        
    }
	
//	@PutMapping("/future/updates{id}")
//	public ResponseEntity<ReqRes> updateUpdates(@PathVariable Long id, @RequestBody UpdatesReqRes updatesReqRes) {
//		return ResponseEntity.ok(employeeManagementService.editUpdates(id, updatesReqRes));
//	}
	
	
//	@PostMapping("/auth/login")
//    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req) {
//		System.out.println("Loggin Emai" + req.getEmail());
//        return ResponseEntity.ok(employeeManagementService.login(req));
//    }
	
	




}
