package com.sharp.empidgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharp.repository.EmployeeRepo;

@Component
public class EmpIdGenerator {
    
	 @Autowired
	    private EmployeeRepo employeeRepo;

	    private static final String PREFIX = "ST";
	    private static final int START_NUMBER = 101;

	    public String generateNewEmpId() {
	        Integer maxEmpIdNumber = employeeRepo.findMaxEmpIdNumber(PREFIX);

	        int newEmpIdNumber = (maxEmpIdNumber != null) ? maxEmpIdNumber + 1 : START_NUMBER;

	        return PREFIX + newEmpIdNumber;
	    }
}