package com.example.qlsv.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.models.Role;
import com.example.qlsv.repositories.RoleRepository;
import com.example.qlsv.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository rolerepository;

    @Override
    public Role findByName(String name) {
        return rolerepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return rolerepository.findAll();
    }

    @Override
    public List<Role> findAllById(List<Long> ids) {
        return rolerepository.findAllById(ids);
    }

    @Override
    public boolean existsById(Long id) {
        return rolerepository.existsById(id);
    }

    @Override
    public long count() {
        return rolerepository.count();
    }

    @Override
    public void deleteById(Long id) {
        rolerepository.deleteById(id);
    }

    @Override
    public com.example.qlsv.models.Role getById(Long id) {
        return rolerepository.getById(id);
    }

    @Override
    public void deleteAll() {
        rolerepository.deleteAll();
    }

    
}
