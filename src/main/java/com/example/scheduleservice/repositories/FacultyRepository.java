package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
