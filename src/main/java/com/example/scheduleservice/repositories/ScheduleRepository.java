package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByGroupIdAndIsDeleted(Long groupId, Boolean isDeleted);
    List<Schedule> findAllByIsDeleted(Boolean isDeleted);
    Optional<Schedule> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
