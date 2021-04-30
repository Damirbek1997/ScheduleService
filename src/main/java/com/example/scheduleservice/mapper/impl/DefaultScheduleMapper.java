package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultScheduleMapper implements ScheduleMapper {
    @Override
    public ScheduleDto toScheduleDto(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();

        scheduleDto.setId(schedule.getId());
        scheduleDto.setSemester(schedule.getSemester());
        scheduleDto.setWeekDay(schedule.getWeekDay());

        scheduleDto.setSubjectId(schedule.getSubject().getId());
        scheduleDto.setSubject(schedule.getSubject().getSubject());

        scheduleDto.setTeacherId(schedule.getSubject().getTeacher().getId());
        scheduleDto.setFirstname(schedule.getSubject().getTeacher().getFirstname());
        scheduleDto.setLastname(schedule.getSubject().getTeacher().getLastname());

        scheduleDto.setSubjectTimeId(schedule.getSubjectTime().getId());
        scheduleDto.setTime(schedule.getSubjectTime().getTime());

        scheduleDto.setGroupId(schedule.getGroup().getId());
        scheduleDto.setGroup(schedule.getGroup().getGroupName());

        scheduleDto.setDepartmentId(schedule.getGroup().getDepartment().getId());
        scheduleDto.setDepartment(schedule.getGroup().getDepartment().getDepartment());

        scheduleDto.setFacultyId(schedule.getGroup().getDepartment().getFaculty().getId());
        scheduleDto.setFaculty(schedule.getGroup().getDepartment().getFaculty().getFaculty());

        scheduleDto.setCabinetId(schedule.getCabinet().getId());
        scheduleDto.setCabinet(schedule.getCabinet().getCabinet());

        return scheduleDto;
    }
}
