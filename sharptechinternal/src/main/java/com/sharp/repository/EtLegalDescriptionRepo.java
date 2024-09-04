
package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.model.EtLegalDescription;

@Repository
public interface EtLegalDescriptionRepo extends JpaRepository<EtLegalDescription, Long>{

}
