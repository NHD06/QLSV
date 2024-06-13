package com.example.qlsv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlsv.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
