package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findByTeacherId(Long teacherId);
    List<Schedule> findAllByGroupId(Long groupId);
    List<Schedule> findAll();
    Schedule findById(Long id);
    Schedule save(Schedule schedule);
    void delete(Long id);
}
