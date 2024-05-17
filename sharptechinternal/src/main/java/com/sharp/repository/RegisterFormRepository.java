package com.sharp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sharp.model.RegisterForm;


@Repository
@EnableJpaRepositories
 
public interface RegisterFormRepository extends JpaRepository<RegisterForm, String> {
    @Query("SELECT e FROM RegisterForm e WHERE e.empEmail = :empEmail AND e.empPassword = :empPassword")
    RegisterForm getEmployeeDetails(@Param("empEmail") String empEmail, @Param("empPassword") String empPassword);

	RegisterForm findByEmpId(String empId);
	
	boolean existsByEmpId(String empId);

	boolean existsByEmpEmail(String empEmail);


	

}