package com.example.qlsv.service;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.Student;

public interface AppUserService {

    AppUser findByUsername(String username);

    AppUser save(AppUser entity);

    List<AppUser> saveAll(List<AppUser> entities);

    List<AppUser> findAll();

    List<AppUser> findAllById(List<Long> ids);

    Optional<AppUser> findById(Long id);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

    AppUser getById(Long id);

    void delete(AppUser entity);

    void deleteAll();

    AppUser checkLogin(String username, String password);

    Long getDepartmentIdByUsername(String username);
}   