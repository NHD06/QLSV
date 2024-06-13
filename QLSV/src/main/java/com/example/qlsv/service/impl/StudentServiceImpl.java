package com.example.qlsv.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.Student;
import com.example.qlsv.repositories.AppUserRepository;
import com.example.qlsv.repositories.StudentRepository;
import com.example.qlsv.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllById(List<Long> ids) {
        return studentRepository.findAllById(ids);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public long count() {
        return studentRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void delete(Student entity) {
        studentRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student findByUser(AppUser user) {
        return studentRepository.findByUser(user);
    }

    @Override
    public Student findStudentByUsername(String username) {
        // Tìm đối tượng AppUser dựa trên username
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) {
            // Nếu tìm thấy AppUser, sử dụng id của nó để tìm sinh viên tương ứng
            return studentRepository.findByUserId(appUser.getId());
        }
        // Nếu không tìm thấy AppUser, trả về null hoặc xử lý tùy theo yêu cầu của bạn
        return null;
    }
    @Override
    public List<Student> getStudentsByDepartmentId(Long departmentId) {
        // Gọi phương thức từ repository để truy vấn danh sách sinh viên của phòng ban dựa trên departmentId
        return studentRepository.findByDepartmentId(departmentId);
    }

    @Override
    public Student getStudentByAppUserId(Long userId) {
        return studentRepository.findByUserId(userId);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findByStudentCodeContainingOrFullnameContainingAndDepartmentId(String studentCode,
            String fullname, Long departmentId) {
        return studentRepository.findByStudentCodeContainingOrFullnameContainingAndDepartmentId(studentCode, fullname, departmentId);
    }
}
