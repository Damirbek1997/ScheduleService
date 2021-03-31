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
    public Schedule save(Schedule newSchedule) {
        scheduleRepository.save(newSchedule);
        return newSchedule;
    }

    @Override
    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
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
    public Schedule changeById(Long id, Schedule newSchedule) throws Exception {
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setGroupId(newSchedule.getGroupId());
                    schedule.setSubjectId(newSchedule.getSubjectId());
                    schedule.setTeacherId(newSchedule.getTeacherId());
                    schedule.setWeekDay(newSchedule.getWeekDay());
                    schedule.setLessonId(newSchedule.getLessonId());

                    return scheduleRepository.save(schedule);
                }).orElseThrow(Exception :: new);
    }
}
