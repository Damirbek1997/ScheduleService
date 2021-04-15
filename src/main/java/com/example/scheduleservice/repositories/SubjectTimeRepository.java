package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.SubjectTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectTimeRepository extends JpaRepository<SubjectTime, Long> {
}
