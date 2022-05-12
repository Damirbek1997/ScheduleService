package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.entities.Department;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(source = "faculty", target = "facultyDto")
    DepartmentDto toDepartmentDto(Department department);

    @InheritInverseConfiguration
    Department toDepartment(DepartmentDto departmentDto);
}
