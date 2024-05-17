package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.model.OpenMortgageDeddInfo;

@Repository
public interface OpenMortgageDeedInfoRepository extends JpaRepository<OpenMortgageDeddInfo, Long>{

}
