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

        scheduleDto.setGroupId(schedule.getGroupId());
        scheduleDto.setLessonId(schedule.getLessonId());
        scheduleDto.setSubjectId(schedule.getSubjectId());
        scheduleDto.setTeacherId(schedule.getTeacherId());
        scheduleDto.setWeekDay(schedule.getWeekDay());

        return scheduleDto;
    }
}
