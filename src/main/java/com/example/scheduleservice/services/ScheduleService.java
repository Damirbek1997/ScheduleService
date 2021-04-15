package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAll();
    Schedule findById(Long id);
    Schedule save(Schedule schedule);
    Schedule changeById(Long id, Schedule schedule) throws Exception;
    void deleteById(Long id);
}
