package com.example.qlsv.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.repositories.AppUserRepository;
import com.example.qlsv.service.AppUserService;

// Đánh dấu lớp này là một service trong Spring
@Service
public class AppUserServiceImpl implements AppUserService {
    
    @Autowired 
    AppUserRepository appUserRepository; // Tự động nối kết AppUserRepository vào trường này

    // Tìm người dùng theo tên đăng nhập
    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    // Lưu người dùng
    @Override
    public AppUser save(AppUser entity) {
        return appUserRepository.save(entity);
    }

    // Lưu danh sách người dùng
    @Override
    public List<AppUser> saveAll(List<AppUser> entities) {
        return appUserRepository.saveAll(entities);
    }

    // Tìm tất cả người dùng
    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    // Tìm tất cả người dùng theo danh sách ID
    @Override
    public List<AppUser> findAllById(List<Long> ids) {
        return appUserRepository.findAllById(ids);
    }

    // Tìm người dùng theo ID
    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepository.findById(id);
    }

    // Kiểm tra sự tồn tại của người dùng theo ID
    @Override
    public boolean existsById(Long id) {
        return appUserRepository.existsById(id);
    }

    // Đếm tổng số người dùng
    @Override
    public long count() {
        return appUserRepository.count();
    }

    // Xóa người dùng theo ID
    @Override
    public void deleteById(Long id) {
        appUserRepository.deleteById(id);
    }

    // Lấy người dùng theo ID (không phải Optional)
    @Override
    public AppUser getById(Long id) {
        return appUserRepository.getById(id);
    }

    // Xóa người dùng
    @Override
    public void delete(AppUser entity) {
        appUserRepository.delete(entity);
    }

    // Xóa tất cả người dùng
    @Override
    public void deleteAll() {
        appUserRepository.deleteAll();
    }

    // Kiểm tra đăng nhập
    @Override
    public AppUser checkLogin(String username, String password) {
        AppUser user = appUserRepository.findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful for user: " + username);
                return user;
            } else {
                System.out.println("Invalid password for user: " + username);
            }
        } else {
            System.out.println("User not found: " + username);
        }
        return null;
    }

    // Lấy ID phòng ban theo tên đăng nhập
    public Long getDepartmentIdByUsername(String username) {
        AppUser user = appUserRepository.findByUsername(username);
        if (user != null) {
            return user.getDepartmentId();
        }
        return null;
    }
}
