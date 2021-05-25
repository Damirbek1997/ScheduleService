package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Cabinet;

import java.util.List;

public interface CabinetService {
    List<Cabinet> findAllFreeCabinets(List<Long> busyCabinets);
    List<Cabinet> findAllByCabinet(String cabinet);
    List<Cabinet> findAllBySubjectTimeId(Long subjectTimeId);
    List<Cabinet> findAll();
    Cabinet findById(Long id);
    Cabinet save(Cabinet cabinet);
    void delete(Long id);
}
