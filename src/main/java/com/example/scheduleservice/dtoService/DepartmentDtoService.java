package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.dto.crud.CreateDepartmentDto;
import com.example.scheduleservice.dto.crud.UpdateDepartmentDto;

import java.util.List;

public interface DepartmentDtoService {
    List<DepartmentDto> findAll();
    DepartmentDto findById(Long id);
    DepartmentDto save(CreateDepartmentDto createDepartmentDto);
    DepartmentDto changeById(Long id, UpdateDepartmentDto updateDepartmentDto) throws Exception;
    void delete(Long id);
}
