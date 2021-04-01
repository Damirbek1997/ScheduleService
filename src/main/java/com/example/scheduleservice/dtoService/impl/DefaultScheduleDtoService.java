package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.dto.crud.CreateScheduleDto;
import com.example.scheduleservice.dto.crud.UpdateScheduleDto;
import com.example.scheduleservice.dtoService.ScheduleDtoService;
import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.mapper.ScheduleMapper;
import com.example.scheduleservice.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultScheduleDtoService implements ScheduleDtoService {
    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public DefaultScheduleDtoService(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public ScheduleDto save(CreateScheduleDto createScheduleDto) {
        Schedule createSchedule = new Schedule();

        // converting to entity
        createSchedule.setGroupId(createScheduleDto.getGroupId());
        createSchedule.setLessonId(createScheduleDto.getLessonId());
        createSchedule.setSubjectId(createScheduleDto.getSubjectId());
        createSchedule.setTeacherId(createScheduleDto.getTeacherId());
        createSchedule.setWeekDay(createScheduleDto.getWeekDay());

        return scheduleMapper.toScheduleDto(scheduleService.save(createSchedule));
    }

    @Override
    public void deleteById(Long id) {
        scheduleService.deleteById(id);
    }

    @Override
    public List<ScheduleDto> findAll() {
        List<Schedule> scheduleList =  scheduleService.findAll();
        List<ScheduleDto> scheduleDtoList = new ArrayList<>();

        scheduleList.forEach(schedule -> {
            ScheduleDto scheduleDto = scheduleMapper.toScheduleDto(schedule);

            scheduleDtoList.add(scheduleDto);
        });

        return scheduleDtoList;
    }

    @Override
    public ScheduleDto findById(Long id) {
        return scheduleMapper.toScheduleDto(scheduleService.findById(id));
    }

    @Override
    public ScheduleDto changeById(Long id, UpdateScheduleDto updateScheduleDto) throws Exception {
        ScheduleDto scheduleDto = new ScheduleDto();

        // converting to entity
        scheduleDto.setGroupId(updateScheduleDto.getGroupId());
        scheduleDto.setLessonId(updateScheduleDto.getLessonId());
        scheduleDto.setSubjectId(updateScheduleDto.getSubjectId());
        scheduleDto.setTeacherId(updateScheduleDto.getTeacherId());
        scheduleDto.setWeekDay(updateScheduleDto.getWeekDay());

        return scheduleMapper.toScheduleDto(scheduleService.findById(id));
    }
}
