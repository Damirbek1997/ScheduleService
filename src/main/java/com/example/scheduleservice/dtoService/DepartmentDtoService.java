package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.dto.crud.CreateDepartmentDto;
import com.example.scheduleservice.dto.crud.UpdateDepartmentDto;

import java.util.List;

public interface DepartmentDtoService {
    List<DepartmentDto> findAllByFacultyId(Long facultyId);
    List<DepartmentDto> findAll();
    DepartmentDto findById(Long id);
    DepartmentDto save(CreateDepartmentDto createDepartmentDto);
    DepartmentDto update(Long id, UpdateDepartmentDto updateDepartmentDto);
    void delete(Long id);
}
