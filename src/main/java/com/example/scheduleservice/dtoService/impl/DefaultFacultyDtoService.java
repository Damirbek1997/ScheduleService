package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.dto.crud.CreateFacultyDto;
import com.example.scheduleservice.dto.crud.UpdateFacultyDto;
import com.example.scheduleservice.dtoService.FacultyDtoService;
import com.example.scheduleservice.entities.Faculty;
import com.example.scheduleservice.mapper.FacultyMapper;
import com.example.scheduleservice.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultFacultyDtoService implements FacultyDtoService {
    private final FacultyService facultyService;

    @Autowired
    public DefaultFacultyDtoService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public List<FacultyDto> findAll() {
        List<Faculty> faculties = facultyService.findAll();
        List<FacultyDto> facultyDtos = new ArrayList<>();

        faculties.forEach(faculty -> {
            FacultyDto facultyDto = FacultyMapper.INSTANCE.toFacultyDto(faculty);

            facultyDtos.add(facultyDto);
        });

        return facultyDtos;
    }

    @Override
    public FacultyDto findById(Long id) {
        return FacultyMapper.INSTANCE.toFacultyDto(facultyService.findById(id));
    }

    @Override
    public FacultyDto save(CreateFacultyDto createFacultyDto) {
        Faculty faculty = new Faculty();

        faculty.setFaculty(createFacultyDto.getFaculty());
        faculty.setIsDeleted(false);

        return FacultyMapper.INSTANCE.toFacultyDto(facultyService.save(faculty));
    }

    @Override
    public FacultyDto update(Long id, UpdateFacultyDto updateFacultyDto) {
        Faculty faculty = facultyService.findById(id);

        faculty.setFaculty(updateFacultyDto.getFaculty());

        return FacultyMapper.INSTANCE.toFacultyDto(facultyService.save(faculty));
    }

    @Override
    public void delete(Long id) {
        Faculty faculty = facultyService.findById(id);

        faculty.setIsDeleted(true);

        facultyService.save(faculty);
    }
}
