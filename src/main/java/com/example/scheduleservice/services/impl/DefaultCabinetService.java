package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Cabinet;
import com.example.scheduleservice.repositories.CabinetRepository;
import com.example.scheduleservice.services.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultCabinetService implements CabinetService {
    private final CabinetRepository cabinetRepository;

    @Autowired
    public DefaultCabinetService(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }

    @Override
    public Cabinet save(Cabinet cabinet) {
        return cabinetRepository.save(cabinet);
    }

    @Override
    public void delete(Long id) {
        cabinetRepository.deleteById(id);
    }

    @Override
    public List<Cabinet> findAll() {
        return cabinetRepository.findAll();
    }

    @Override
    public List<Cabinet> findAllFreeCabinets() {
        return null;
    }

    @Override
    public Cabinet findById(Long id) {
        return cabinetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Group with " + id + " not found!"));
    }

    @Override
    public Cabinet changeById(Long id, Cabinet newCabinet) throws Exception {
        return cabinetRepository.findById(id).
                map(cabinet -> {
                    cabinet.setCabinet(newCabinet.getCabinet());

                    return cabinetRepository.save(cabinet);
                }).orElseThrow(Exception :: new);
    }
}
