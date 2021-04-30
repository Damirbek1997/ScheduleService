package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.TeacherMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeacherMapper implements TeacherMapper {
    private final SubjectMapper subjectMapper;
    private final UserMapper userMapper;

    @Autowired
    public DefaultTeacherMapper(SubjectMapper subjectMapper, UserMapper userMapper) {
        this.subjectMapper = subjectMapper;
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

        if (teacher.getSubjects() != null) {
            List<SubjectDto> subjectDtos = new ArrayList<>();

            teacher.getSubjects().forEach(subject -> subjectDtos.add(subjectMapper.toSubjectDto(subject)));

            teacherDto.setSubjectDtos(subjectDtos);
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

        if (teacherDto.getSubjectDtos() != null) {
            List<Subject> subjects = new ArrayList<>();

            teacherDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));

            teacher.setSubjects(subjects);
        }

        return teacher;
    }
}
