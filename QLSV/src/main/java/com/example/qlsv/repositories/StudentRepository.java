package com.example.qlsv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Student findByUser(AppUser user);
    Student findByUserId(Long userId);
    List<Student> findByDepartmentId(Long departmentId);
    // Phương thức tìm kiếm sinh viên theo mã sinh viên hoặc tên sinh viên
    List<Student> findByStudentCodeContainingOrFullnameContaining(String studentCode, String fullname);

     // Phương thức tìm kiếm sinh viên theo mã sinh viên
     List<Student> findByStudentCode(String studentCode);

     List<Student> findByStudentCodeContainingOrFullnameContainingAndDepartmentId(String studentCode, String fullname, Long departmentId);
}
