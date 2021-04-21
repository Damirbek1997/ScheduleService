package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.FrontScheduleDto;
import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.dto.crud.CreateScheduleDto;
import com.example.scheduleservice.dto.crud.UpdateScheduleDto;

import java.util.List;

public interface ScheduleDtoService {
    List<ScheduleDto> findAll();
    List<FrontScheduleDto> findAllByGroupId(Long groupId);
    ScheduleDto findById(Long id);
    ScheduleDto save(CreateScheduleDto createScheduleDto);
    ScheduleDto changeById(Long id, UpdateScheduleDto updateScheduleDto) throws Exception;
    void deleteById(Long id);
}
