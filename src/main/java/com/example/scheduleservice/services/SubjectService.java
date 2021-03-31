package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();
    Subject findById(Long id);
    Subject save(Subject newSubject);
    Subject changeById(Long id, Subject newSubject) throws Exception;
    void deleteById(Long id);
}
