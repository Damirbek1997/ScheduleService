package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.entities.Teacher;

public interface TeacherMapper {
    TeacherDto toTeacherDto(Teacher teacher);
}
