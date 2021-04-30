package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(Long id);
    Teacher save(Teacher teacher);
    void delete(Long id);
}
