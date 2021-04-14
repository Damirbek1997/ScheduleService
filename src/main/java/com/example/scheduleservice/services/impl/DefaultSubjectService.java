package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.repositories.SubjectRepository;
import com.example.scheduleservice.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultSubjectService implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public DefaultSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject newSubject) {
        subjectRepository.save(newSubject);
        return newSubject;
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Subject with " + id + "not found!"));
    }

    @Override
    public Subject changeById(Long id, Subject newSubject) throws Exception {
        return subjectRepository.findById(id)
                .map(subject -> {
                    subject.setSubject(newSubject.getSubject());
                    subject.setTeacher(newSubject.getTeacher());
                    subject.setUserSet(newSubject.getUserSet());

                    return subjectRepository.save(subject);
                }).orElseThrow(Exception :: new);
    }
}