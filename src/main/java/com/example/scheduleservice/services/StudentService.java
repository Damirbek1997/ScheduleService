package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Student;
import com.example.scheduleservice.entities.User;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    List<Student> findAllByGroupId(Long groupId);
    Student findById(Long id);
    Student save(Student student);
    void delete(Long id);
}
