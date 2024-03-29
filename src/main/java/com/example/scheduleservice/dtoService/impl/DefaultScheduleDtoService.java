package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.dto.crud.CreateScheduleDto;
import com.example.scheduleservice.dto.crud.UpdateScheduleDto;
import com.example.scheduleservice.dtoService.ScheduleDtoService;
import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.mapper.ScheduleMapper;
import com.example.scheduleservice.services.CabinetService;
import com.example.scheduleservice.services.GroupService;
import com.example.scheduleservice.services.ScheduleService;
import com.example.scheduleservice.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultScheduleDtoService implements ScheduleDtoService {
    private final ScheduleService scheduleService;
    private final SubjectService subjectService;
    private final GroupService groupService;
    private final CabinetService cabinetService;

    @Autowired
    public DefaultScheduleDtoService(ScheduleService scheduleService, SubjectService subjectService,
                                     GroupService groupService, CabinetService cabinetService) {
        this.scheduleService = scheduleService;
        this.subjectService = subjectService;
        this.groupService = groupService;
        this.cabinetService = cabinetService;
    }

    @Override
    public List<ScheduleDto> findByTeacherId(Long teacherId) {
        List<Schedule> scheduleList = scheduleService.findByTeacherId(teacherId);
        List<ScheduleDto> frontScheduleDtos = new ArrayList<>();

        scheduleList.forEach(schedule -> {
            ScheduleDto scheduleDto = ScheduleMapper.INSTANCE.toScheduleDto(schedule);

            frontScheduleDtos.add(scheduleDto);
        });

        return frontScheduleDtos;
    }

    @Override
    public List<ScheduleDto> findAllByGroupId(Long groupId) {
        List<Schedule> scheduleList = scheduleService.findAllByGroupId(groupId);
        List<ScheduleDto> frontScheduleDtos = new ArrayList<>();

        scheduleList.forEach(schedule -> {
            ScheduleDto scheduleDto = ScheduleMapper.INSTANCE.toScheduleDto(schedule);

            frontScheduleDtos.add(scheduleDto);
        });

        return frontScheduleDtos;
    }

    @Override
    public List<ScheduleDto> findAll() {
        List<Schedule> scheduleList = scheduleService.findAll();
        List<ScheduleDto> scheduleDtoList = new ArrayList<>();


        scheduleList.forEach(schedule -> {
            ScheduleDto scheduleDto = ScheduleMapper.INSTANCE.toScheduleDto(schedule);

            scheduleDtoList.add(scheduleDto);
        });

        return scheduleDtoList;
    }

    @Override
    public ScheduleDto findById(Long id) {
        return ScheduleMapper.INSTANCE.toScheduleDto(scheduleService.findById(id));
    }

    @Override
    public ScheduleDto findByWeekDayAndScheduleTimeId(String weekDay, Long scheduleTimeId) {
        return ScheduleMapper.INSTANCE.toScheduleDto(scheduleService.findByWeekDayAndScheduleTimeId(weekDay, scheduleTimeId));
    }

    @Override
    public ScheduleDto save(CreateScheduleDto createScheduleDto) {
        Schedule schedule = new Schedule();

        schedule.setSemester(createScheduleDto.getSemester());
        schedule.setWeekDay(createScheduleDto.getWeekDay());
        schedule.setSubject(subjectService.findById(createScheduleDto.getSubjectId()));
        schedule.setGroup(groupService.findById(createScheduleDto.getGroupId()));
        schedule.setCabinet(cabinetService.findById(createScheduleDto.getCabinetId()));
        schedule.setIsDeleted(false);

        return ScheduleMapper.INSTANCE.toScheduleDto(scheduleService.save(schedule));
    }

    @Override
    public ScheduleDto update(Long id, UpdateScheduleDto updateScheduleDto) {
        Schedule schedule = scheduleService.findById(id);

        schedule.setSemester(updateScheduleDto.getSemester());
        schedule.setWeekDay(updateScheduleDto.getWeekDay());

        if (updateScheduleDto.getSubjectId() != null) {
            schedule.setSubject(subjectService.findById(updateScheduleDto.getSubjectId()));
        }

        if (updateScheduleDto.getGroupId() != null) {
            schedule.setGroup(groupService.findById(updateScheduleDto.getGroupId()));
        }

        if (updateScheduleDto.getCabinetId() != null) {
            schedule.setCabinet(cabinetService.findById(updateScheduleDto.getCabinetId()));
        }

        return ScheduleMapper.INSTANCE.toScheduleDto(scheduleService.save(schedule));
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = scheduleService.findById(id);

        schedule.setIsDeleted(true);

        scheduleService.save(schedule);
    }
}
