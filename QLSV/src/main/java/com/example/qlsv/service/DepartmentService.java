package com.example.qlsv.service;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.models.Department;
import com.example.qlsv.models.Student;

public interface DepartmentService {

    Department save(Department entity);

    List<Department> saveAll(List<Department> entities);

    List<Department> findAll();

    List<Department> findAllById(List<Long> ids);

    Optional<Department> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

    Department getById(Long id);

    void deleteAll();

    long count();

    List<Student> getStudentsByDepartmentId(Long departmentId);

}