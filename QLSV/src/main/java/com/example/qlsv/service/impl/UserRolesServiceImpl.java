package com.example.qlsv.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.models.UserRoles;
import com.example.qlsv.repositories.UserRoleRepository;
import com.example.qlsv.service.UserRolesService;

@Service
public class UserRolesServiceImpl implements UserRolesService {
    
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRoles save(UserRoles entity) {
        return userRoleRepository.save(entity);
    }

    @Override
    public List<UserRoles> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public List<UserRoles> findAllById(List<Long> ids) {
        return userRoleRepository.findAllById(ids);
    }

    @Override
    public Optional<UserRoles> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public long count() {
        return userRoleRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public UserRoles getById(Long id) {
        return userRoleRepository.getById(id);
    }

    @Override
    public void delete(UserRoles entity) {
        userRoleRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        userRoleRepository.deleteAll();
    }

    
}
