package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByIsDeleted(Boolean isDeleted);
    Optional<Faculty> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
