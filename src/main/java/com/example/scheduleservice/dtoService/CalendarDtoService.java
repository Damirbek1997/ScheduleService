package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.CalendarDto;
import com.example.scheduleservice.dto.crud.CreateCalendarDto;
import com.example.scheduleservice.dto.crud.UpdateCalendarDto;

import java.util.List;

public interface CalendarDtoService {
    List<CalendarDto> findAll();
    CalendarDto findById(Long id);
    CalendarDto save(CreateCalendarDto createCalendarDto);
    CalendarDto changeById(Long id, UpdateCalendarDto updateCalendarDto) throws Exception;
    void delete(Long id);
}
