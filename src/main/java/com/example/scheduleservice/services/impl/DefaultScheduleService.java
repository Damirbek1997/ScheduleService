package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.repositories.ScheduleRepository;
import com.example.scheduleservice.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultScheduleService implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public DefaultScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAllByGroupId(Long groupId) {
        return scheduleRepository.retrieveSchedulesByGroupId(groupId);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Schedule with " + id + " not found!"));
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
