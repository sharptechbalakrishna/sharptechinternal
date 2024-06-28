package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.model.EtAdditionalInfo;

@Repository
public interface EtAdditionalInfoRepository extends JpaRepository<EtAdditionalInfo, Long>{

}
