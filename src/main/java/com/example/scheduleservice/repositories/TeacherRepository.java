package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
