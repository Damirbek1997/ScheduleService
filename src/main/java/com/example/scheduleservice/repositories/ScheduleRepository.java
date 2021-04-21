package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "SELECT s FROM Schedule s where s.group.id = :groupId")
    List<Schedule> retrieveSchedulesByGroupId(Long groupId);
}
