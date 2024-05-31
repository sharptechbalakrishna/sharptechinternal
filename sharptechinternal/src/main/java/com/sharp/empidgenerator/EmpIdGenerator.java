package com.sharp.empidgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharp.repository.EmployeeRepo;

@Component
public class EmpIdGenerator {
	
	@Autowired
    private EmployeeRepo employeeRepo;

    private static final String PREFIX = "STS";
    private static final int NUMERIC_PART_LENGTH = 3;

    public String generateNewEmpId() {
        String latestEmpId = employeeRepo.findLatestEmpId();

        int newEmpIdNumber = 1;
        if (latestEmpId != null && latestEmpId.startsWith(PREFIX)) {
            String numericPart = latestEmpId.substring(PREFIX.length());
            try {
                newEmpIdNumber = Integer.parseInt(numericPart) + 1;
            } catch (NumberFormatException e) {
                newEmpIdNumber = 1;
            }
        }

        return PREFIX + String.format("%0" + NUMERIC_PART_LENGTH + "d", newEmpIdNumber);
    }

}
