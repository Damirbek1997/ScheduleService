package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Calendar;
import com.example.scheduleservice.repositories.CalendarRepository;
import com.example.scheduleservice.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultCalendarService implements CalendarService {
    private final CalendarRepository calendarRepository;

    @Autowired
    public DefaultCalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public Calendar save(Calendar calendar) {
        calendarRepository.save(calendar);
        return calendar;
    }

    @Override
    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }

    @Override
    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    @Override
    public Calendar findById(Long id) {
        return calendarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Calendar with " + id + " not found!"));
    }

    @Override
    public Calendar changeById(Long id, Calendar newCalendar) throws Exception {
        return calendarRepository.findById(id)
                .map(calendar -> {
                    calendar.setSemesterId(newCalendar.getSemesterId());
                    calendar.setWeekDay(newCalendar.getWeekDay());
                    calendar.setWeekDayName(newCalendar.getWeekDayName());
                    calendar.setLessonId(newCalendar.getLessonId());
                    calendar.setLessonTime(newCalendar.getLessonTime());

                    return calendarRepository.save(calendar);
                }).orElseThrow(Exception :: new);
    }
}