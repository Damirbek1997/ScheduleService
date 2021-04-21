package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.ScheduleTimeDto;

import java.util.List;

public interface SubjectTimeDtoService {
    List<ScheduleTimeDto> findAll();
    ScheduleTimeDto findById(Long id);
}
