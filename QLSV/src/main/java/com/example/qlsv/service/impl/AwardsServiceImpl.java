package com.example.qlsv.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlsv.models.AwardsDisciplines;
import com.example.qlsv.repositories.AwardsRepository;
import com.example.qlsv.service.AwardsService;

@Service
public class AwardsServiceImpl implements AwardsService{
    @Autowired
    AwardsRepository awardsRepository;

    @Override
    public AwardsDisciplines save(AwardsDisciplines entity) {
        return awardsRepository.save(entity);
    }

    @Override
    public List<AwardsDisciplines> saveAll(List<AwardsDisciplines> entities) {
        return awardsRepository.saveAll(entities);
    }

    @Override
    public List<AwardsDisciplines> findAll() {
        return awardsRepository.findAll();
    }

    @Override
    public List<AwardsDisciplines> findAllById(List<Long> ids) {
        return awardsRepository.findAllById(ids);
    }

    @Override
    public Optional<AwardsDisciplines> findById(Long id) {
        return awardsRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return awardsRepository.existsById(id);
    }

    @Override
    public long count() {
        return awardsRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        awardsRepository.deleteById(id);
    }

    @Override
    public AwardsDisciplines getById(Long id) {
        return awardsRepository.getById(id);
    }

    @Override
    public void delete(AwardsDisciplines entity) {
        awardsRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        awardsRepository.deleteAll();
    }
    
    
}
