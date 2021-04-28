package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.dto.crud.CreateFacultyDto;
import com.example.scheduleservice.dto.crud.UpdateFacultyDto;
import com.example.scheduleservice.dtoService.FacultyDtoService;
import com.example.scheduleservice.entities.Department;
import com.example.scheduleservice.entities.Faculty;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.mapper.FacultyMapper;
import com.example.scheduleservice.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultFacultyDtoService implements FacultyDtoService {
    private final FacultyService facultyService;
    private final FacultyMapper facultyMapper;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DefaultFacultyDtoService(FacultyService facultyService, FacultyMapper facultyMapper, DepartmentMapper departmentMapper) {
        this.facultyService = facultyService;
        this.facultyMapper = facultyMapper;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public FacultyDto save(CreateFacultyDto createFacultyDto) {
        Faculty faculty = new Faculty();

        // converting to entity
        faculty.setFaculty(createFacultyDto.getFaculty());

        return facultyMapper.toFacultyDto(facultyService.save(faculty));
    }

    @Override
    public void delete(Long id) {
        facultyService.delete(id);
    }

    @Override
    public List<FacultyDto> findAll() {
        List<Faculty> faculties = facultyService.findAll();
        List<FacultyDto> facultyDtos = new ArrayList<>();

        faculties.forEach(faculty -> {
            FacultyDto facultyDto = facultyMapper.toFacultyDto(faculty);

            facultyDtos.add(facultyDto);
        });

        return facultyDtos;
    }

    @Override
    public FacultyDto findById(Long id) {
        return facultyMapper.toFacultyDto(facultyService.findById(id));
    }

    @Override
    public FacultyDto changeById(Long id, UpdateFacultyDto updateFacultyDto) throws Exception {
        Faculty faculty = new Faculty();

        // converting to entity
        faculty.setFaculty(updateFacultyDto.getFaculty());

        return facultyMapper.toFacultyDto(facultyService.changeById(id, faculty));
    }
}
