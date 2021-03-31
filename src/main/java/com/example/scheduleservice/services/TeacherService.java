package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(Long id);
    Teacher save(Teacher newTeacher);
    Teacher changeById(Long id, Teacher newTeacher) throws Exception;
    void deleteById(Long id);
}
