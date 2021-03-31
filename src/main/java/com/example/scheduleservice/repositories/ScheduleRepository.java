package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
