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
    public List<Cabinet> findAll() {
        return cabinetRepository.findAllByIsDeleted(false);
    }

    @Override
    public Cabinet findById(Long id) {
        return cabinetRepository.findByIdAndIsDeleted(id, false).orElseThrow(() -> new EntityNotFoundException("Cabinet with id " + id + " not found!"));
    }

    @Override
    public List<Cabinet> findAllFreeCabinets(List<Long> busyCabinets) {
        return cabinetRepository.retrieveAllFreeCabinetsNotInList(busyCabinets);
    }

    @Override
    public List<Cabinet> findAllByCabinet(String cabinet) {
        return cabinetRepository.findAllByCabinetAndIsDeleted(cabinet, false);
    }

    @Override
    public List<Cabinet> findAllBySubjectTimeId(Long subjectTimeId) {
        return cabinetRepository.findAllBySubjectTimeIdAndIsDeleted(subjectTimeId, false);
    }

    @Override
    public Cabinet save(Cabinet cabinet) {
        return cabinetRepository.save(cabinet);
    }

    @Override
    public void delete(Long id) {
        cabinetRepository.deleteById(id);
    }
}
