package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.CalendarDto;
import com.example.scheduleservice.entities.Calendar;

public interface CalendarMapper {
    CalendarDto toCalendarDto(Calendar calendar);
}
