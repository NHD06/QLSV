package com.example.qlsv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlsv.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
