package com.example.qlsv.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.models.Department;
import com.example.qlsv.models.Student;
import com.example.qlsv.repositories.DepartmentRepository;
import com.example.qlsv.repositories.StudentRepository;
import com.example.qlsv.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public List<Department> saveAll(List<Department> entities) {
        return departmentRepository.saveAll(entities);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findAllById(List<Long> ids) {
        return departmentRepository.findAllById(ids);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.getById(id);
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }

    @Override
    public long count() {
        return departmentRepository.count();
    }

    @Override
    public List<Student> getStudentsByDepartmentId(Long departmentId) {
        return studentRepository.findByDepartmentId(departmentId);
    }
}
