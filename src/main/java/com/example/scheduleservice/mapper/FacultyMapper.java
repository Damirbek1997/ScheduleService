package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.entities.Faculty;

public interface FacultyMapper {
    FacultyDto toFacultyDto(Faculty faculty);
    Faculty toFaculty(FacultyDto facultyDto);
}
