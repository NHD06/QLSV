package com.example.qlsv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlsv.models.UserRoles;

public interface UserRoleRepository extends JpaRepository<UserRoles, Long>{
    
}
