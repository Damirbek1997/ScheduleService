package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
