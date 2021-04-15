package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.dto.crud.CreateFacultyDto;
import com.example.scheduleservice.dto.crud.UpdateFacultyDto;

import java.util.List;

public interface FacultyDtoService {
    List<FacultyDto> findAll();
    FacultyDto findById(Long id);
    FacultyDto save(CreateFacultyDto createFacultyDto);
    FacultyDto changeById(Long id, UpdateFacultyDto updateFacultyDto) throws Exception;
    void delete(Long id);
}
