package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    List<Department> findByFacultyId(Long facultyId);
    Department findById(Long id);
    Department save(Department department);
    void delete(Long id);
}
