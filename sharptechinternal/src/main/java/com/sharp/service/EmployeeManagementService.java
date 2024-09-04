package com.sharp.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sharp.dto.ReqRes;
import com.sharp.dto.UpdatesReqRes;
import com.sharp.empidgenerator.EmpIdGenerator;
import com.sharp.model.Employee;
import com.sharp.model.LoginHistory;
import com.sharp.model.LoginOtp;
import com.sharp.model.Updates;
import com.sharp.repository.EmployeeRepo;
import com.sharp.repository.LoginHistoryRepo;
import com.sharp.repository.UpdatesRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeManagementService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private LoginHistoryRepo loginHistoryRepo;

	@Autowired
	private EmpIdGenerator empIdGenerator;

	@Autowired
	private EmailService emailService;

	@Autowired
	private OtpService otpService;

	@Autowired
	private UpdatesRepository updatesRepository;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeManagementService.class);

//	public ReqRes login(ReqRes loginRequest) {
//		ReqRes response = new ReqRes();
//		try {
//	        // Check if the email is registered
//	        Employee user = employeeRepo.findByEmail(loginRequest.getEmail())
//	                                    .orElseThrow(() -> new NoSuchElementException("User not registered"));
//
//	        // Authenticate the user
//	        try {
//	            authenticationManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//	        } catch (BadCredentialsException e) {
//	            throw new IllegalArgumentException("Incorrect password");
//	        }
//			var jwt = jwtUtils.generateToken(user);
//			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
//
//			// Save login information
//			LoginHistory loginHistory = new LoginHistory();
//			loginHistory.setEmail(user.getEmail());
//			loginHistory.setLoginTime(new Date(System.currentTimeMillis()));
//			String transactionId = UUID.randomUUID().toString();
//			loginHistory.setTransactionid(transactionId);
//			loginHistory.setStatus("Active");
//			loginHistoryRepo.save(loginHistory);
//			
//			response.setStatusCode(200);
//			response.setToken(jwt);
//			response.setRole(user.getRole());
//			response.setRefreshToken(refreshToken);
//			response.setExpirationTime("24Hrs");
//			response.setTransactionId(transactionId);
//			response.setMessage("Successfully Logged In");
//		} catch (NoSuchElementException e) {
//	        response.setStatusCode(404);
//	        response.setMessage("User not registered");
//	    } catch (IllegalArgumentException e) {
//	        response.setStatusCode(401);
//	        response.setMessage("Incorrect password");
//	    } catch (Exception e) {
//	        response.setStatusCode(500);
//	        response.setMessage("An unexpected error occurred: " + e.getMessage());
//	    }
//		
//		
//		return response;
//	}

	public ReqRes login(ReqRes loginRequest) {
		ReqRes response = new ReqRes();
		try {
			// Check if the email is registered
			Employee user = employeeRepo.findByEmail(loginRequest.getEmail())
					.orElseThrow(() -> new NoSuchElementException("User not registered"));

			// Authenticate the user
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			} catch (BadCredentialsException e) {
				throw new IllegalArgumentException("Incorrect password");
			}

			// Generate and send OTP
			String otp = otpService.generateOtp(user.getEmail());
			emailService.sendOtp(user.getEmail(), otp);

			response.setStatusCode(200);
			response.setMessage("OTP sent to registered email. Please verify.");
		} catch (NoSuchElementException e) {
			response.setStatusCode(404);
			response.setMessage("User not registered");
		} catch (IllegalArgumentException e) {
			response.setStatusCode(401);
			response.setMessage("Incorrect password");
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("An unexpected error occurred: " + e.getMessage());
		}

		return response;
	}

	@Transactional
	public ReqRes verifyOtp(String email, String otp) {
		ReqRes response = new ReqRes();
		try {
			// Retrieve and validate OTP
			LoginOtp loginOtp = otpService.getOtp(email)
					.orElseThrow(() -> new IllegalArgumentException("Invalid or expired OTP"));

			if (!loginOtp.getOtp().equals(otp)
					|| loginOtp.getExpirationTime().before(new Date(System.currentTimeMillis()))) {
				throw new IllegalArgumentException("Invalid or expired OTP");
			}

			// OTP is valid, delete it from the database
			otpService.deleteOtp(email);

			// Fetch user details
			Employee user = employeeRepo.findByEmail(email)
					.orElseThrow(() -> new NoSuchElementException("User not registered"));

			// Generate JWT and refresh token
			var jwt = jwtUtils.generateToken(user);
			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);

			// Save login information
			LoginHistory loginHistory = new LoginHistory();
			loginHistory.setEmail(user.getEmail());
			loginHistory.setLoginTime(new Date(System.currentTimeMillis()));
			String transactionId = UUID.randomUUID().toString();
			loginHistory.setTransactionid(transactionId);
			loginHistory.setStatus("Active");
			loginHistoryRepo.save(loginHistory);

			response.setStatusCode(200);
			response.setToken(jwt);
			response.setRole(user.getRole());
			response.setRefreshToken(refreshToken);
			response.setExpirationTime("24Hrs");
			response.setTransactionId(transactionId);
			response.setMessage("Successfully Logged In");
		} catch (NoSuchElementException e) {
			response.setStatusCode(404);
			response.setMessage("User not registered");
		} catch (IllegalArgumentException e) {
			response.setStatusCode(401);
			response.setMessage("Invalid or expired OTP");
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("An unexpected error occurred: " + e.getMessage());
		}

		return response;
	}

	public ReqRes logout(String email, String transactionId) {
		ReqRes response = new ReqRes();
		try {
			LoginHistory loginHistory = loginHistoryRepo.findByEmailAndTransactionid(email, transactionId)
					.orElseThrow(() -> new Exception(
							"No login record found for email: " + email + " and transactionId: " + transactionId));
			loginHistory.setLogoutTime(new Date(System.currentTimeMillis()));
			loginHistory.setStatus("Closed");
			loginHistory.setTransactionid("Expired");
			loginHistoryRepo.save(loginHistory);

			response.setStatusCode(200);
			response.setMessage("Successfully Logged Out");
			logger.info("Logout time updated for email: {}", email);
		} catch (Exception e) {
			logger.error("Error during logout for email {}: {}", email, e.getMessage());
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
		}
		return response;
	}

//	The below commented line for register should be remove after regestering atleast 1 Admin
	public ReqRes register(ReqRes registrationRequest
//			, String adminEmail
	) {
		ReqRes resp = new ReqRes();

		try {

			// Check if email already exists
			Optional<Employee> existingUserByEmail = employeeRepo.findByEmail(registrationRequest.getEmail());
			if (existingUserByEmail.isPresent()) {
				resp.setStatusCode(400); // Bad Request
				resp.setMessage("This email is already registered with another user.");
				return resp;
			}

			String newEmpId = empIdGenerator.generateNewEmpId();
			Employee employee = new Employee();
			employee.setEmail(registrationRequest.getEmail());

			employee.setPhoneNumber(registrationRequest.getPhoneNumber());
			employee.setAlternatePhoneNumber(registrationRequest.getAlternatePhoneNumber());

			employee.setRole(registrationRequest.getRole());
			employee.setFirstName(registrationRequest.getFirstName());
			employee.setMiddleName(registrationRequest.getMiddleName());
			employee.setLastName(registrationRequest.getLastName());
			employee.setEmpId(newEmpId);
			employee.setFatherName(registrationRequest.getFatherName());
			employee.setMotherName(registrationRequest.getMotherName());
			employee.setQualification(registrationRequest.getQualification());
			employee.setDateOfBirth(registrationRequest.getDateOfBirth());
			employee.setPassword(registrationRequest.getPassword());
			employee.setJoiningDate(registrationRequest.getJoiningDate());
			employee.setReleavingDate(registrationRequest.getReleavingDate());
			employee.setDesignation(registrationRequest.getDesignation());
			employee.setSalary(registrationRequest.getSalary());
			employee.setAadhaarNumber(registrationRequest.getAadhaarNumber());
			employee.setAddress(registrationRequest.getAddress());
			employee.setPanNumber(registrationRequest.getPanNumber());
			employee.setRemark(registrationRequest.getRemark());
			employee.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
			employee.setRegisterDate(new Date(System.currentTimeMillis()));
//			employee.setRegisteredBy(adminEmail);

			Employee employeeResult = employeeRepo.save(employee);

			if (employeeResult.getId() > 0) {
				resp.setEmployee((employeeResult));
				resp.setMessage(" Saved Successfully");
				resp.setStatusCode(200);
			}

		} catch (Exception e) {
			resp.setStatusCode(500);
			resp.setError(e.getMessage());
		}

		return resp;
	}

	public ReqRes refreshToken(ReqRes refreshTokenReqiest) {
		ReqRes response = new ReqRes();
		try {
			String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
			Employee users = employeeRepo.findByEmail(ourEmail).orElseThrow();
			if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
				var jwt = jwtUtils.generateToken(users);
				response.setStatusCode(200);
				response.setToken(jwt);
				response.setRefreshToken(refreshTokenReqiest.getToken());
				response.setExpirationTime("24Hr");
				response.setMessage("Successfully Refreshed Token");
			}
			response.setStatusCode(200);
			return response;

		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	public ReqRes getAllUsers() {
		ReqRes reqRes = new ReqRes();

		try {
			List<Employee> result = employeeRepo.findAll();
			if (!result.isEmpty()) {
				reqRes.setEmployeeList(result);
				reqRes.setStatusCode(200);
				reqRes.setMessage("Successful");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("No users found");
			}
			return reqRes;
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred: " + e.getMessage());
			return reqRes;
		}
	}

	public ReqRes getUsersById(Long id) {
		ReqRes reqRes = new ReqRes();
		try {
			Employee usersById = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
			reqRes.setEmployee(usersById);
			reqRes.setStatusCode(200);
			reqRes.setMessage("Users with id '" + id + "' found successfully");
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes getUsersByEmpId(String empId) {
		ReqRes reqRes = new ReqRes();
		try {
			Employee user = employeeRepo.findByEmpId(empId).orElseThrow(() -> new RuntimeException("User Not found"));
			reqRes.setEmployee(user);
			reqRes.setStatusCode(200);
			reqRes.setMessage("User with empId '" + empId + "' found successfully");
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes deleteUser(Long userId) {
		ReqRes reqRes = new ReqRes();
		try {
			Optional<Employee> userOptional = employeeRepo.findById(userId);
			if (userOptional.isPresent()) {
				employeeRepo.deleteById(userId);
				reqRes.setStatusCode(200);
				reqRes.setMessage("User deleted successfully");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("User not found for deletion");
			}
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes updateUser(Long userId, Employee updatedUser) {
		ReqRes reqRes = new ReqRes();
		try {
			Optional<Employee> userOptional = employeeRepo.findById(userId);

			if (!userOptional.isPresent()) {
				reqRes.setStatusCode(404); // Not Found
				reqRes.setMessage("User not found for update");
				return reqRes;
			}

			Employee existingUser = userOptional.get();

//			Optional<Employee> existingUserByEmail = employeeRepo.findByEmpId(updatedUser.getEmpId());

			// Check if the empId in updatedUser is different from the current user's empId
			if (!existingUser.getEmpId().equals(updatedUser.getEmpId())) {

				// Check if the new empId already exists for another user
				Optional<Employee> existingUserByEmpId = employeeRepo.findByEmpId(updatedUser.getEmpId());
				if (existingUserByEmpId.isPresent()) {
					reqRes.setStatusCode(400); // Bad Request
					reqRes.setMessage("This empId is already registered with another user.");
					return reqRes;
				}
			}

			// Check if the email in updatedUser is different from the current user's email
			if (!existingUser.getEmail().equals(updatedUser.getEmail())) {

				// Check if the new email already exists for another user
				Optional<Employee> existingUserByEmail = employeeRepo.findByEmail(updatedUser.getEmail());
				if (existingUserByEmail.isPresent()) {
					reqRes.setStatusCode(400); // Bad Request
					reqRes.setMessage("This email is already registered with another user.");
					return reqRes;
				}
			}

//			// Check if email already exists
//			if (existingUserByEmail.isPresent()) {
//				reqRes.setStatusCode(400); // Bad Request
//				reqRes.setMessage("This email is already registered with another user.");
//				return reqRes;
//			}

			// Check if empId already exists
//			if (existingUserByEmail.isPresent()) {
//			reqRes.setStatusCode(400); // Bad Request
//			reqRes.setMessage("This empId is already registered with another user.");
//			return reqRes;
//		}

			if (userOptional.isPresent()) {
				existingUser.setEmail(updatedUser.getEmail());

				existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
				existingUser.setAlternatePhoneNumber(updatedUser.getAlternatePhoneNumber());

				existingUser.setEmpId(updatedUser.getEmpId());
				existingUser.setFirstName(updatedUser.getFirstName());
				existingUser.setMiddleName(updatedUser.getFirstName());
				existingUser.setLastName(updatedUser.getLastName());
				existingUser.setFatherName(updatedUser.getFatherName());
				existingUser.setMotherName(updatedUser.getMotherName());
				existingUser.setDesignation(updatedUser.getDesignation());
				existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
				existingUser.setAddress(updatedUser.getAddress());
				existingUser.setJoiningDate(updatedUser.getJoiningDate());
				existingUser.setSalary(updatedUser.getSalary());
				existingUser.setQualification(updatedUser.getQualification());
				existingUser.setReleavingDate(updatedUser.getReleavingDate());
				existingUser.setAadhaarNumber(updatedUser.getAadhaarNumber());
				existingUser.setPanNumber(updatedUser.getPanNumber());
				existingUser.setRemark(updatedUser.getRemark());
				existingUser.setRole(updatedUser.getRole());

				// Check if password is present in the request
//				if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
//					// Encode the password and update it
//					existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//				}

				Employee savedUser = employeeRepo.save(existingUser);
				reqRes.setEmployee(savedUser);
				reqRes.setStatusCode(200);
				reqRes.setMessage("Updated successfully");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("User not found for update");
			}
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes getMyInfo(String email) {
		ReqRes reqRes = new ReqRes();
		try {
			Optional<Employee> userOptional = employeeRepo.findByEmail(email);
			if (userOptional.isPresent()) {
				reqRes.setEmployee(userOptional.get());
				reqRes.setStatusCode(200);
				reqRes.setMessage("successful");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("User not found for update");
			}

		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
		}
		return reqRes;

	}

	public UpdatesReqRes getAllUpdates() {
		UpdatesReqRes reqRes = new UpdatesReqRes();

		try {
			List<Updates> result = updatesRepository.findAll();
			if (!result.isEmpty()) {
				reqRes.setUpdatesList(result);
				reqRes.setStatusCode(200);
				reqRes.setMessage("Successful");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("No updates found");
			}
			return reqRes;
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred: " + e.getMessage());
			return reqRes;
		}
	}

	public Updates saveUpdate(UpdatesReqRes updatesReqRes) {
		
		Updates update = new Updates();
		
		UpdatesReqRes reqRes = new UpdatesReqRes();

		try {
			update.setTitle(updatesReqRes.getTitle());
			update.setDescription(updatesReqRes.getDescription());
			update.setReleaseDate(updatesReqRes.getReleaseDate());
			update.setCreatedBy(updatesReqRes.getCreatedBy());
			update.setCreatedDate(updatesReqRes.getCreatedDate());
			update.setVisible(updatesReqRes.isVisible());
			update.setUrl(updatesReqRes.getUrl());

			Updates updatesResult = updatesRepository.save(update);
			return updatesResult;
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while saving update: " + e.getMessage());
			// Log the error message or throw a custom exception if necessary
			return null; // or throw new RuntimeException("Failed to save update", e);
		}
	}
//	public Updates editUpdates(Long id,UpdatesReqRes updatesReqRes) {
//		Updates update = new Updates();
//		UpdatesReqRes reqRes = new UpdatesReqRes();
//		
//		return ("Sucessfully Updated");
//	}

}
