package com.sharp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sharp.model.EtGeneralInfo;
import com.sharp.model.PropertyInfo;

//@Repository
//
//public interface PropertyInfoRepository extends JpaRepository<PropertyInfo, String>{
//
//	
//		@Query("SELECT e FROM PropertyInfo e INNER JOIN FETCH e.vestingdeedinfo v WHERE e.propertyAddress = :propertyAddress")
//	    List<PropertyInfo> findByPropertyAddressWithVestingInfo(@Param("propertyAddress") String propertyAddress);
//	    
//	    @Query("SELECT e FROM PropertyInfo e INNER JOIN FETCH e.openMortgageDeddInfo m WHERE e.propertyAddress = :propertyAddress")
//	    List<PropertyInfo> findByPropertyAddressWithOpenMortageDeedInfo(@Param("propertyAddress") String propertyAddress);
//	
//}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface PropertyInfoRepository extends JpaRepository<PropertyInfo, String> {

    @Query("SELECT e FROM PropertyInfo e INNER JOIN FETCH e.vestingdeedinfo v WHERE e.propertyAddress = :propertyAddress")
    List<PropertyInfo> findByPropertyAddressWithVestingInfo(@Param("propertyAddress") String propertyAddress);
    
    @Query("SELECT p FROM PropertyInfo p JOIN FETCH p.absopenmortgagedeedinfo m WHERE p.propertyAddress = :propertyAddress")
    List<PropertyInfo> findByPropertyAddressWithOpenMortgageDeedInfo(@Param("propertyAddress") String propertyAddress);

	//List<PropertyInfo> searchByAddress(String propertyAddress);
	
//	 @Query("SELECT e FROM PropertyInfo e WHERE e.propertyAddress LIKE %:partialAddress%")
//	    List<PropertyInfo> searchByAddress(@Param("propertyAddress") String propertyAddress);
//    
	 
    @Query("SELECT e FROM PropertyInfo e WHERE e.propertyAddress LIKE %:partialAddress%")
    List<PropertyInfo> searchByAddress(@Param("partialAddress") String partialAddress);
    
    
    PropertyInfo findByOrderNumber(String orderNumber);
    
    
}

