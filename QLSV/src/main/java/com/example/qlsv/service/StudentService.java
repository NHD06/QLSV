package com.example.qlsv.service;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.Student;

public interface StudentService {

    Student save(Student entity);

    List<Student> findAll();

    List<Student> findAllById(List<Long> ids);

    Student findById(Long id);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

    Student getById(Long id);

    void delete(Student entity);

    void deleteAll();

    Student findByUser(AppUser user);

    Student findStudentByUsername(String username);

    List<Student> getStudentsByDepartmentId(Long departmentId);

    Student getStudentByAppUserId(Long userId);

    Student getStudentById(Long id);

    List<Student> findByStudentCodeContainingOrFullnameContainingAndDepartmentId(String studentCode, String fullname, Long departmentId);
}