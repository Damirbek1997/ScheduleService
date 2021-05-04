package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByIsDeleted(Boolean isDeleted);
    Optional<Teacher> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
