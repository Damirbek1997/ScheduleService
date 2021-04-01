package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.CalendarDto;
import com.example.scheduleservice.dto.crud.CreateCalendarDto;
import com.example.scheduleservice.dto.crud.UpdateCalendarDto;
import com.example.scheduleservice.dtoService.CalendarDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendars")
public class CalendarController {
    private final CalendarDtoService calendarDtoService;

    @Autowired
    public CalendarController(CalendarDtoService calendarDtoService) {
        this.calendarDtoService = calendarDtoService;
    }

    @GetMapping
    private List<CalendarDto> getAll() {
       return calendarDtoService.findAll();
    }

    @GetMapping("/{id}")
    private CalendarDto getById(@PathVariable("id") Long id) {
        return calendarDtoService.findById(id);
    }

    @PutMapping("/{id}")
    private CalendarDto change(@PathVariable("id") Long id, @RequestBody UpdateCalendarDto updateCalendarDto) throws Exception {
        return calendarDtoService.changeById(id, updateCalendarDto);
    }

    @PostMapping
    private CalendarDto create(@RequestBody CreateCalendarDto createCalendarDto) {
        return calendarDtoService.save(createCalendarDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        calendarDtoService.delete(id);
    }
}
