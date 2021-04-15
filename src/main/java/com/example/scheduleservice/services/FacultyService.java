package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAll();
    Faculty findById(Long id);
    Faculty save(Faculty faculty);
    Faculty changeById(Long id, Faculty faculty) throws Exception;
    void delete(Long id);
}
