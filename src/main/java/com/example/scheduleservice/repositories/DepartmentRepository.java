package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByFacultyIdAndIsDeleted(Long facultyId, Boolean isDeleted);
    List<Department> findAllByIsDeleted(Boolean isDeleted);
    Optional<Department> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
