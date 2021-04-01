package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.CalendarDto;
import com.example.scheduleservice.dto.crud.CreateCalendarDto;
import com.example.scheduleservice.dto.crud.UpdateCalendarDto;
import com.example.scheduleservice.dtoService.CalendarDtoService;
import com.example.scheduleservice.entities.Calendar;
import com.example.scheduleservice.mapper.CalendarMapper;
import com.example.scheduleservice.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCalendarDtoDtoService implements CalendarDtoService {
    private final CalendarService calendarService;
    private final CalendarMapper calendarMapper;

    @Autowired
    public DefaultCalendarDtoDtoService(CalendarService calendarService, CalendarMapper calendarMapper) {
        this.calendarService = calendarService;
        this.calendarMapper = calendarMapper;
    }

    @Override
    public CalendarDto save(CreateCalendarDto createCalendarDto) {
        Calendar createCalendar = new Calendar();

        // converting to entity
        createCalendar.setLessonId(createCalendarDto.getLessonId());
        createCalendar.setLessonTime(createCalendarDto.getLessonTime());
        createCalendar.setSemesterId(createCalendarDto.getSemesterId());
        createCalendar.setWeekDay(createCalendarDto.getWeekDay());
        createCalendar.setWeekDayName(createCalendarDto.getWeekDayName());

        return calendarMapper.toCalendarDto(calendarService.save(createCalendar));
    }

    @Override
    public void delete(Long id) {
        calendarService.delete(id);
    }

    @Override
    public List<CalendarDto> findAll() {
        List<Calendar> calendarList = calendarService.findAll();
        List<CalendarDto> calendarDtoList = new ArrayList<>();

        calendarList.forEach(calendar -> {
            CalendarDto calendarDto = calendarMapper.toCalendarDto(calendar);

            calendarDtoList.add(calendarDto);
        });

        return calendarDtoList;
    }

    @Override
    public CalendarDto findById(Long id) {
        return calendarMapper.toCalendarDto(calendarService.findById(id));
    }

    @Override
    public CalendarDto changeById(Long id, UpdateCalendarDto updateCalendarDto) throws Exception {
        Calendar updateCalendar = new Calendar();

        // converting to entity
        updateCalendar.setLessonId(updateCalendarDto.getLessonId());
        updateCalendar.setLessonTime(updateCalendarDto.getLessonTime());
        updateCalendar.setSemesterId(updateCalendarDto.getSemesterId());
        updateCalendar.setWeekDay(updateCalendarDto.getWeekDay());
        updateCalendar.setWeekDayName(updateCalendarDto.getWeekDayName());

        return calendarMapper.toCalendarDto(calendarService.save(updateCalendar));
    }
}