package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.SubjectTime;
import com.example.scheduleservice.repositories.SubjectTimeRepository;
import com.example.scheduleservice.services.SubjectTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultSubjectTimeService implements SubjectTimeService {
    private final SubjectTimeRepository subjectTimeRepository;

    @Autowired
    public DefaultSubjectTimeService(SubjectTimeRepository subjectTimeRepository) {
        this.subjectTimeRepository = subjectTimeRepository;
    }
    @Override
    public List<SubjectTime> findAll() {
        return subjectTimeRepository.findAll();
    }

    @Override
    public SubjectTime findById(Long id) {
        return subjectTimeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Subject time with " + id + " not found!"));
    }
}
