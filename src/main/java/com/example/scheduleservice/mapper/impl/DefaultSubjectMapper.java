package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.TeacherMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectMapper implements SubjectMapper {
    private final DepartmentMapper departmentMapper;
    private final TeacherMapper teacherMapper;

    @Autowired
    public DefaultSubjectMapper(DepartmentMapper departmentMapper, TeacherMapper teacherMapper) {
        this.departmentMapper = departmentMapper;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public SubjectDto toSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setSubject(subject.getSubject());

        if (subject.getDepartment() != null) {
            subjectDto.setDepartmentDto(departmentMapper.toDepartmentDto(subject.getDepartment()));
        }

        if (subject.getTeacher() != null) {
            subjectDto.setTeacherDto(teacherMapper.toTeacherDto(subject.getTeacher()));
        }

        return subjectDto;
    }

    @Override
    public Subject toSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setId(subjectDto.getId());
        subject.setSubject(subjectDto.getSubject());

        if (subjectDto.getDepartmentDto() != null) {
            subject.setDepartment(departmentMapper.toDepartment(subjectDto.getDepartmentDto()));
        }

        if (subjectDto.getTeacherDto() != null) {
            subject.setTeacher(teacherMapper.toTeacher(subjectDto.getTeacherDto()));
        }

        return subject;
    }
}
