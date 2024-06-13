package com.example.qlsv.service;

import java.util.List;

import com.example.qlsv.models.Role;

public interface RoleService {

    Role findByName(String name);

    List<Role> findAll();

    List<Role> findAllById(List<Long> ids);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

    com.example.qlsv.models.Role getById(Long id);

    void deleteAll();

}