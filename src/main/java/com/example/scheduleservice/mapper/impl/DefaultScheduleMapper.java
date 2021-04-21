package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.FrontScheduleDto;
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
        scheduleDto.setSemester(schedule.getSemester());
        scheduleDto.setWeekDay(schedule.getWeekDay());

        if (schedule.getSubject() != null)
            scheduleDto.setSubjectDto(subjectMapper.toSubjectDto(schedule.getSubject()));

        if (schedule.getSubjectTime() != null)
            scheduleDto.setScheduleTimeDto(subjectTimeMapper.toSubjectTime(schedule.getSubjectTime()));

        if (schedule.getGroup() != null)
            scheduleDto.setGroupDto(groupMapper.toGroupDto(schedule.getGroup()));

        if (schedule.getCabinet() != null)
            scheduleDto.setCabinetDto(cabinetMapper.toCabinetDto(schedule.getCabinet()));

        return scheduleDto;
    }

    @Override
    public FrontScheduleDto toFrontScheduleDto(Schedule schedule) {
        FrontScheduleDto frontScheduleDto = new FrontScheduleDto();

        frontScheduleDto.setScheduleId(schedule.getId());
        frontScheduleDto.setSemester(schedule.getSemester());
        frontScheduleDto.setWeekDay(schedule.getWeekDay());
        frontScheduleDto.setSubjectId(schedule.getSubject().getId());
        frontScheduleDto.setSubject(schedule.getSubject().getSubject());
        frontScheduleDto.setScheduleTimeId(schedule.getSubjectTime().getId());
        frontScheduleDto.setStartLesson(schedule.getSubjectTime().getStartLesson());
        frontScheduleDto.setEndLesson(schedule.getSubjectTime().getEndLesson());
        frontScheduleDto.setGroupId(schedule.getGroup().getId());
        frontScheduleDto.setGroupName(schedule.getGroup().getGroupName());
        frontScheduleDto.setCabinetId(schedule.getCabinet().getId());
        frontScheduleDto.setCabinet(schedule.getCabinet().getCabinet());

        return frontScheduleDto;
    }
}
