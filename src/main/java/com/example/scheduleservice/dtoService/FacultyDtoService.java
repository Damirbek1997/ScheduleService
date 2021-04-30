package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.dto.crud.CreateFacultyDto;
import com.example.scheduleservice.dto.crud.UpdateFacultyDto;

import java.util.List;

public interface FacultyDtoService {
    List<FacultyDto> findAll();
    FacultyDto findById(Long id);
    FacultyDto save(CreateFacultyDto createFacultyDto);
    FacultyDto update(Long id, UpdateFacultyDto updateFacultyDto);
    void delete(Long id);
}
