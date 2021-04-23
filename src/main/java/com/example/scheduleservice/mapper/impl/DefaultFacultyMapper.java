package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.entities.Faculty;
import com.example.scheduleservice.mapper.FacultyMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultFacultyMapper implements FacultyMapper {
    @Override
    public FacultyDto toFacultyDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();

        facultyDto.setId(faculty.getId());
        facultyDto.setFaculty(faculty.getFaculty());

        return facultyDto;
    }

    @Override
    public Faculty toFaculty(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();

        faculty.setId(facultyDto.getId());
        faculty.setFaculty(facultyDto.getFaculty());

        return faculty;
    }
}
