package com.example.qlsv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.qlsv.models.AppUser;

//Kho lưu trữ dữ liệu sau truy vấn
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    // Các phương thức truy vấn dữ liệu có sẵn
    AppUser findByUsername(String username);
    Long findDepartmentIdByUsername(String username);
}
