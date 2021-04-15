package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
