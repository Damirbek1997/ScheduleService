package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.dto.crud.CreateScheduleDto;
import com.example.scheduleservice.dto.crud.UpdateScheduleDto;

import java.util.List;

public interface ScheduleDtoService {
    List<ScheduleDto> findAllByGroupId(Long groupId);
    List<ScheduleDto> findAll();
    ScheduleDto findById(Long id);
    ScheduleDto save(CreateScheduleDto createScheduleDto);
    ScheduleDto update(Long id, UpdateScheduleDto updateScheduleDto);
    void delete(Long id);
}
