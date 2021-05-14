package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.mapper.TeacherMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultTeacherMapper implements TeacherMapper {
    private final UserMapper userMapper;

    @Autowired
    public DefaultTeacherMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public TeacherDto toTeacherDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId(teacher.getId());
        teacherDto.setFirstname(teacher.getFirstname());
        teacherDto.setLastname(teacher.getLastname());

        if (teacher.getUser() != null) {
            teacherDto.setUserDto(userMapper.toUserDto(teacher.getUser()));
        }

        return teacherDto;
    }

    @Override
    public Teacher toTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();

        teacher.setId(teacherDto.getId());
        teacher.setFirstname(teacherDto.getFirstname());
        teacher.setLastname(teacherDto.getLastname());

        if (teacherDto.getUserDto() != null) {
            teacher.setUser(userMapper.toUser(teacherDto.getUserDto()));
        }

        return teacher;
    }
}
