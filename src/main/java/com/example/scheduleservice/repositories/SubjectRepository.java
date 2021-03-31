package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
