package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByGroupIdAndIsDeleted(Long groupId, Boolean isDeleted);
    List<Student> findAllByIsDeleted(Boolean isDeleted);
    Optional<Student> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
