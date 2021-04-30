package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAll();
    Faculty findById(Long id);
    Faculty save(Faculty faculty);
    void delete(Long id);
}
