package com.example.qlsv.service;

import java.util.List;
import java.util.Optional;

import com.example.qlsv.models.AwardsDisciplines;

public interface AwardsService {

    AwardsDisciplines save(AwardsDisciplines entity);

    List<AwardsDisciplines> saveAll(List<AwardsDisciplines> entities);

    List<AwardsDisciplines> findAll();

    List<AwardsDisciplines> findAllById(List<Long> ids);

    Optional<AwardsDisciplines> findById(Long id);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

    AwardsDisciplines getById(Long id);

    void delete(AwardsDisciplines entity);

    void deleteAll();

}