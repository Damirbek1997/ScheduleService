package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Cabinet;

import java.util.List;

public interface CabinetService {
    List<Cabinet> findAll();
    List<Cabinet> findAllFreeCabinets();
    Cabinet findById(Long id);
    Cabinet save(Cabinet cabinet);
    Cabinet changeById(Long id, Cabinet cabinet) throws Exception;
    void delete(Long id);
}
