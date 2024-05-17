package com.sharp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.model.AbsActiveJudgementsAndLines;

@Repository
public interface AbsActiveJudgementsAndLinesRepository extends JpaRepository<AbsActiveJudgementsAndLines, Long>{

}
