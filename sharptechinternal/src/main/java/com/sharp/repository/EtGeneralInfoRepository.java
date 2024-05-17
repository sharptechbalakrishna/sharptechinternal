package com.sharp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sharp.model.EtGeneralInfo;

public interface EtGeneralInfoRepository extends JpaRepository<EtGeneralInfo, String>{
	
	

	EtGeneralInfo findByOrderNumber(String orderNumber);

	 @Query("SELECT e FROM EtGeneralInfo e INNER JOIN FETCH e.etvestinginfo v WHERE e.propertyAdderess = :propertyAddress")
	    List<EtGeneralInfo> findByPropertyAddressWithVestingInfo(@Param("propertyAddress") String propertyAddress);
	    
	 @Query("SELECT e FROM EtGeneralInfo e INNER JOIN FETCH e.etopenmortagedeedinfo m WHERE e.propertyAdderess = :propertyAddress")
	 List<EtGeneralInfo> findByPropertyAddressWithOpenMortageDeedInfo(@Param("propertyAddress") String propertyAddress);

	
	 
	 @Query("SELECT e FROM EtGeneralInfo e WHERE e.propertyAdderess LIKE %:partialAddress%")
	    List<EtGeneralInfo> searchByAddress(@Param("partialAddress") String partialAddress);
}
	
	