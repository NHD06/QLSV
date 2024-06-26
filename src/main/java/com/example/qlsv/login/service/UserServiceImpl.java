package com.example.qlsv.login.service;

import com.example.qlsv.login.model.User;
import com.example.qlsv.login.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;




@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        return (List<User>) userRepository.saveAll(entities);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> findAllById(List<String> ids) {
        return (List<User>) userRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<String> ids) {
        userRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<User> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Optional<User> optional = findById(username);
        if(optional.isPresent() && optional.get().getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
