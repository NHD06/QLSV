package com.example.qlsv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlsv.models.AwardsDisciplines;

public interface AwardsRepository extends JpaRepository<AwardsDisciplines, Long>{
    
}
