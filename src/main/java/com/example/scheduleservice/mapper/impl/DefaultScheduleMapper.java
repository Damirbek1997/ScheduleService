package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultScheduleMapper implements ScheduleMapper {
    private final SubjectMapper subjectMapper;
    private final SubjectTimeMapper subjectTimeMapper;
    private final GroupMapper groupMapper;
    private final CabinetMapper cabinetMapper;

    @Autowired
    public DefaultScheduleMapper(SubjectMapper subjectMapper, SubjectTimeMapper subjectTimeMapper, GroupMapper groupMapper, CabinetMapper cabinetMapper) {
        this.subjectMapper = subjectMapper;
        this.subjectTimeMapper = subjectTimeMapper;
        this.groupMapper = groupMapper;
        this.cabinetMapper = cabinetMapper;
    }

    @Override
    public ScheduleDto toScheduleDto(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();

        scheduleDto.setId(schedule.getId());
        scheduleDto.setWeekDay(schedule.getWeekDay());
        scheduleDto.setSubjectDto(subjectMapper.toSubjectDto(schedule.getSubject()));
        scheduleDto.setSubjectTimeDto(subjectTimeMapper.toSubjectTime(schedule.getSubjectTime()));
        scheduleDto.setGroupDto(groupMapper.toGroupDto(schedule.getGroup()));
        scheduleDto.setCabinetDto(cabinetMapper.toCabinetDto(schedule.getCabinet()));

        return scheduleDto;
    }
}
