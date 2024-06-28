package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.model.DasAdditionalInfo;
@Repository
public interface DasAdditionalInfoRepository extends JpaRepository<DasAdditionalInfo, Long>{

}
