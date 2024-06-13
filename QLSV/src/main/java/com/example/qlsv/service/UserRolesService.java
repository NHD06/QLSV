package com.example.qlsv.service;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.models.UserRoles;

public interface UserRolesService {

    UserRoles save(UserRoles entity);

    List<UserRoles> findAll();

    List<UserRoles> findAllById(List<Long> ids);

    Optional<UserRoles> findById(Long id);

    long count();

    void deleteById(Long id);

    UserRoles getById(Long id);

    void delete(UserRoles entity);

    void deleteAll();

}