package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.dto.crud.CreateTeacherDto;
import com.example.scheduleservice.dto.crud.UpdateTeacherDto;

import java.util.List;

public interface TeacherDtoService {
    List<TeacherDto> findAll();
    TeacherDto findById(Long id);
    TeacherDto save(CreateTeacherDto createTeacherDto);
    TeacherDto update(UpdateTeacherDto updateTeacherDto);
}
