package com.sharp.empidgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharp.repository.EmployeeRepo;

@Component
public class EmpIdGenerator {
	
	@Autowired
    private EmployeeRepo employeeRepo;

    private static final String PREFIX = "ST";
    private static final int NUMERIC_PART_LENGTH = 3;
    private static final int START_NUMBER = 101;

    public String generateNewEmpId() {
        String latestEmpId = employeeRepo.findLatestEmpId();

        int newEmpIdNumber = START_NUMBER;;
        if (latestEmpId != null && latestEmpId.startsWith(PREFIX)) {
            String numericPart = latestEmpId.substring(PREFIX.length());
            try {
            	int latestNumber = Integer.parseInt(numericPart);
            	newEmpIdNumber = Math.max(latestNumber + 1, START_NUMBER); // Ensure it never goes below 101
            } catch (NumberFormatException e) {
                newEmpIdNumber =  START_NUMBER;
            }
        }
        return PREFIX + String.format("%0" + NUMERIC_PART_LENGTH + "d", newEmpIdNumber);
    }
}