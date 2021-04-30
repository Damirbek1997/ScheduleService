package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.dto.crud.CreateScheduleDto;
import com.example.scheduleservice.dto.crud.UpdateScheduleDto;
import com.example.scheduleservice.dtoService.ScheduleDtoService;
import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.mapper.ScheduleMapper;
import com.example.scheduleservice.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultScheduleDtoService implements ScheduleDtoService {
    private final ScheduleMapper scheduleMapper;
    private final ScheduleService scheduleService;
    private final SubjectService subjectService;
    private final SubjectTimeService subjectTimeService;
    private final GroupService groupService;
    private final CabinetService cabinetService;

    @Autowired
    public DefaultScheduleDtoService(ScheduleService scheduleService, ScheduleMapper scheduleMapper, SubjectService subjectService,
                                     SubjectTimeService subjectTimeService, GroupService groupService, CabinetService cabinetService) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
        this.subjectService = subjectService;
        this.subjectTimeService = subjectTimeService;
        this.groupService = groupService;
        this.cabinetService = cabinetService;
    }

    @Override
    public List<ScheduleDto> findAllByGroupId(Long groupId) {
        List<Schedule> scheduleList = scheduleService.findAllByGroupId(groupId);
        List<ScheduleDto> frontScheduleDtos = new ArrayList<>();

        scheduleList.forEach(schedule -> {
            ScheduleDto scheduleDto = scheduleMapper.toScheduleDto(schedule);

            frontScheduleDtos.add(scheduleDto);
        });

        return frontScheduleDtos;
    }

    @Override
    public List<ScheduleDto> findAll() {
        List<Schedule> scheduleList = scheduleService.findAll();
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
    public ScheduleDto save(CreateScheduleDto createScheduleDto) {
        Schedule schedule = new Schedule();

        schedule.setSemester(createScheduleDto.getSemester());
        schedule.setWeekDay(createScheduleDto.getWeekDay());
        schedule.setSubject(subjectService.findById(createScheduleDto.getSubjectId()));
        schedule.setSubjectTime(subjectTimeService.findById(createScheduleDto.getSubjectTimeId()));
        schedule.setCabinet(cabinetService.findById(createScheduleDto.getCabinetId()));

        if (schedule.getGroup() != null) {
            schedule.setGroup(groupService.findById(createScheduleDto.getGroupId()));
        }

        return scheduleMapper.toScheduleDto(scheduleService.save(schedule));
    }

    @Override
    public ScheduleDto update(Long id, UpdateScheduleDto updateScheduleDto) {
        Schedule schedule = scheduleService.findById(id);

        schedule.setSemester(updateScheduleDto.getSemester());
        schedule.setWeekDay(updateScheduleDto.getWeekDay());

        if (updateScheduleDto.getSubjectId() != null) {
            schedule.setSubject(subjectService.findById(updateScheduleDto.getSubjectId()));
        }

        if (updateScheduleDto.getSubjectTimeId() != null) {
            schedule.setSubjectTime(subjectTimeService.findById(updateScheduleDto.getSubjectTimeId()));
        }

        if (updateScheduleDto.getGroupId() != null) {
            schedule.setGroup(groupService.findById(updateScheduleDto.getGroupId()));
        }

        if (updateScheduleDto.getCabinetId() != null) {
            schedule.setCabinet(cabinetService.findById(updateScheduleDto.getCabinetId()));
        }

        return scheduleMapper.toScheduleDto(scheduleService.save(schedule));
    }

    @Override
    public void delete(Long id) {
        scheduleService.delete(id);
    }
}
