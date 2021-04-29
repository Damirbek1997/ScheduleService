package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.entities.Teacher;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeacherMapper implements TeacherMapper {
    private final SubjectMapper subjectMapper;

    @Autowired
    public DefaultTeacherMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public TeacherDto toTeacherDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId(teacher.getId());

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

        teacher.setId(teacher.getId());

        if (teacherDto.getSubjectDtos() != null) {
            List<Subject> subjects = new ArrayList<>();

            teacherDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));

            teacher.setSubjects(subjects);
        }

        return teacher;
    }
}
