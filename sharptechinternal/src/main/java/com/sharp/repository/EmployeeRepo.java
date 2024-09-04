package com.sharp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sharp.model.Employee;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByEmpId(String empId);
	
	@Query(value = "SELECT emp_id FROM employee ORDER BY emp_id DESC LIMIT 1", nativeQuery = true)
    String findLatestEmpId();
	
	 boolean existsByEmail(String email);
	 
	 @Query("SELECT MAX(CAST(SUBSTRING(e.empId, 3) AS int)) FROM Employee e WHERE e.empId LIKE :prefix%")
	 Integer findMaxEmpIdNumber(@Param("prefix") String prefix);
	 
	 
	 

}
