package com.sharp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.exception.UserNotFoundException;
import com.sharp.model.LoginForm;
import com.sharp.model.RegisterForm;
import com.sharp.repository.RegisterFormRepository;


@RestController
@ComponentScan
@CrossOrigin("http://localhost:3000")
public class RegisterFormController {
	
	@Autowired
	private RegisterFormRepository registerFormRepository;
	//

//	@PostMapping("/register")
//	 public RegisterForm newRegisterForm(@RequestBody RegisterForm newRegisterForm) {
//
//		return RegisterFormRepository.save(newRegisterForm);
//	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerRegisterForm( @RequestBody RegisterForm newRegisterForm, BindingResult result) {
	    if (result.hasErrors()) {
	        return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
	    }

	    // Check if the RegisterForm ID already exists
	    RegisterForm existingRegisterForm = registerFormRepository.findByEmpId(newRegisterForm.getEmpId());
	    if (existingRegisterForm != null) {
	        return new ResponseEntity<>("RegisterForm ID already exists", HttpStatus.BAD_REQUEST);
	    }

	    // Check if the email already exists
	    boolean emailExists = registerFormRepository.existsByEmpEmail(newRegisterForm.getEmpEmail());
	    if (emailExists) {
	        return new ResponseEntity<>("Email already exists. Please use another email.", HttpStatus.BAD_REQUEST);
	    }

	    // Proceed with registration
	    RegisterForm savedRegisterForm = registerFormRepository.save(newRegisterForm);
	    return new ResponseEntity<>(savedRegisterForm, HttpStatus.CREATED);
	}
	
	 
	
	@GetMapping("/checkRegisterFormId/{empId}")
	public ResponseEntity<Boolean> checkRegisterFormIdExists(@PathVariable String empId) {
	    boolean exists = registerFormRepository.existsByEmpId(empId);
	    return ResponseEntity.ok(exists);
	}
	
	@GetMapping("/checkEmail/{empEmail}")
	public ResponseEntity<Boolean> checkEmailExists(@PathVariable String empEmail) {
	    boolean exists = registerFormRepository.existsByEmpEmail(empEmail);
	    return ResponseEntity.ok(exists);
	}

	
	
	@GetMapping("/user")
	public List<RegisterForm> getRegisterForms()
	{
		return registerFormRepository.findAll();
	
	}
	
	
//	
//	 @GetMapping("/emp/{empId}")
//	    public ResponseEntity<RegisterForm> getRegisterFormById(@PathVariable String empId) {
//	        Optional<RegisterForm> RegisterForm = RegisterFormRepository.findById(empId);
//	        if (RegisterForm.isPresent()) {
//	            return new ResponseEntity<>(RegisterForm.get(), HttpStatus.OK);
//	        } else {
//	            throw new UserNotFoundException(empId);
//	        }
//	    }
	
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<RegisterForm> getRegisterFormById(@PathVariable String empId) {
	    RegisterForm RegisterForm = registerFormRepository.findByEmpId(empId);
	    if (RegisterForm != null) {
	        return new ResponseEntity<>(RegisterForm, HttpStatus.OK);
	    } else {
	        throw new UserNotFoundException(empId);
	    }
	}


	
	
	
//	@PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) throws Exception {
//		RegisterForm RegisterForm = RegisterFormRepository.getRegisterFormDetails(loginForm.getEmpEmail() , loginForm.getEmpPassword() );
//		
//		if(RegisterForm != null) {
//            return new ResponseEntity<>(RegisterForm, HttpStatus.OK);
//        }
//        else 
//        {
//          //  return new ResponseEntity<>(new IncurrectCredientials("User Does't exist....Please Register"), HttpStatus.NOT_FOUND);
//        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
	
	
	@GetMapping("/display/user")
	List<RegisterForm> getAllRegisterForm(){ 
	
	return registerFormRepository.findAll();	}
}



