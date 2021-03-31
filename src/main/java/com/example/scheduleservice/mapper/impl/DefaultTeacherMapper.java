package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultTeacherMapper implements TeacherMapper {
    @Override
    public TeacherDto toTeacherDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId(teacher.getId());
        teacherDto.setFirstname(teacher.getFirstname());
        teacherDto.setLastname(teacher.getLastname());

        return teacherDto;
    }
}
