package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.entities.Calendar;

import java.util.List;

public interface CalendarDtoService {
    List<Calendar> findAll();
    Calendar findById(Long id);
    Calendar save(Calendar calendar);
    Calendar changeById(Long id, Calendar newCalendar) throws Exception;
    void delete(Long id);
}
