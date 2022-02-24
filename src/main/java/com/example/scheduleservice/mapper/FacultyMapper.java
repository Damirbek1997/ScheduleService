package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.entities.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacultyMapper {
    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);

    FacultyDto toFacultyDto(Faculty faculty);
    Faculty toFaculty(FacultyDto facultyDto);
}
