package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.CalendarDto;
import com.example.scheduleservice.entities.Calendar;
import com.example.scheduleservice.mapper.CalendarMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultCalendarMapper implements CalendarMapper {
    @Override
    public CalendarDto toCalendarDto(Calendar calendar) {
        CalendarDto calendarDto = new CalendarDto();

        calendarDto.setLessonId(calendar.getLessonId());
        calendarDto.setLessonTime(calendar.getLessonTime());
        calendarDto.setSemesterId(calendar.getSemesterId());
        calendarDto.setWeekDay(calendar.getWeekDay());
        calendarDto.setWeekDayName(calendar.getWeekDayName());

        return calendarDto;
    }
}
