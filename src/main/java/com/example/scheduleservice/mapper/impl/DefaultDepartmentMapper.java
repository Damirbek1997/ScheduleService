package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.entities.Department;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.mapper.FacultyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDepartmentMapper implements DepartmentMapper {
    private final FacultyMapper facultyMapper;

    @Autowired
    public DefaultDepartmentMapper(FacultyMapper facultyMapper) {
        this.facultyMapper = facultyMapper;
    }

    @Override
    public DepartmentDto toDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId(department.getId());
        departmentDto.setDepartment(department.getDepartment());

        if (department.getFaculty() != null)
            departmentDto.setFacultyDto(facultyMapper.toFacultyDto(department.getFaculty()));

        return departmentDto;
    }

    @Override
    public Department toDepartment(DepartmentDto departmentDto) {
        Department department = new Department();

        department.setId(departmentDto.getId());
        department.setDepartment(departmentDto.getDepartment());

        if (departmentDto.getFacultyDto() != null)
            department.setFaculty(facultyMapper.toFaculty(departmentDto.getFacultyDto()));

        return department;
    }
}
