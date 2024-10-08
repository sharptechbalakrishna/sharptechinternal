
package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sharp.model.DasLegalDescription;

@Repository
public interface DasLegalDescriptionRepo extends JpaRepository<DasLegalDescription, Long>{

}
