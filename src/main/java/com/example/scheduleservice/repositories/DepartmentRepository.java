package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value = "SELECT d FROM Department d where d.faculty.id = :facultyId")
    List<Department> retrieveDepartmentsByFacultyId(Long facultyId);
}
