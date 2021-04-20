package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findById(Long id);
    List<Department> findByFacultyId(Long facultyId);
    Department save(Department department);
    Department changeById(Long id, Department department) throws Exception;
    void delete(Long id);
}
