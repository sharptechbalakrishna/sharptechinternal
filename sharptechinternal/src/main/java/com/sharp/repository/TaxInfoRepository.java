package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.model.TaxInfo;

@Repository
public interface TaxInfoRepository extends JpaRepository<TaxInfo, Long>{

}
