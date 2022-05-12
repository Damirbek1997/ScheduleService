package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.dto.crud.CreateDepartmentDto;
import com.example.scheduleservice.dto.crud.UpdateDepartmentDto;
import com.example.scheduleservice.dtoService.DepartmentDtoService;
import com.example.scheduleservice.entities.Department;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.services.DepartmentService;
import com.example.scheduleservice.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultDepartmentDtoService implements DepartmentDtoService {
    private final DepartmentService departmentService;
    private final FacultyService facultyService;

    @Autowired
    public DefaultDepartmentDtoService(DepartmentService departmentService, FacultyService facultyService) {
        this.departmentService = departmentService;
        this.facultyService = facultyService;
    }

    @Override
    public List<DepartmentDto> findAllByFacultyId(Long facultyId) {
        List<Department> departments = departmentService.findAllByFacultyId(facultyId);
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDto groupDto = DepartmentMapper.INSTANCE.toDepartmentDto(department);

            departmentDtos.add(groupDto);
        });

        return departmentDtos;
    }

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentService.findAll();
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDto groupDto = DepartmentMapper.INSTANCE.toDepartmentDto(department);

            departmentDtos.add(groupDto);
        });

        return departmentDtos;
    }

    @Override
    public DepartmentDto findById(Long id) {
        return DepartmentMapper.INSTANCE.toDepartmentDto(departmentService.findById(id));
    }

    @Override
    public DepartmentDto save(CreateDepartmentDto createDepartmentDto) {
        Department department = new Department();

        department.setDepartment(createDepartmentDto.getDepartment());
        department.setIsDeleted(false);

        if (createDepartmentDto.getFacultyId() != null) {
            department.setFaculty(facultyService.findById(createDepartmentDto.getFacultyId()));
        }

        return DepartmentMapper.INSTANCE.toDepartmentDto(departmentService.save(department));
    }

    @Override
    public DepartmentDto update(Long id, UpdateDepartmentDto updateDepartmentDto) {
        Department department = departmentService.findById(id);

        department.setDepartment(updateDepartmentDto.getDepartment());

        if (updateDepartmentDto.getFacultyId() != null) {
            department.setFaculty(facultyService.findById(updateDepartmentDto.getFacultyId()));
        }

        return DepartmentMapper.INSTANCE.toDepartmentDto(departmentService.save(department));
    }

    @Override
    public void delete(Long id) {
        Department department = departmentService.findById(id);

        department.setIsDeleted(true);

        departmentService.save(department);
    }
}
