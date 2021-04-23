package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.entities.Department;

public interface DepartmentMapper {
    DepartmentDto toDepartmentDto(Department department);
    Department toDepartment(DepartmentDto departmentDto);
}
