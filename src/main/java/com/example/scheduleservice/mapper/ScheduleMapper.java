package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.entities.Schedule;

public interface ScheduleMapper {
    ScheduleDto toScheduleDto(Schedule schedule);
}
