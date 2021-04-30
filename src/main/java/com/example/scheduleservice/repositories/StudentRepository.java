package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByGroupId(Long groupId);
}
