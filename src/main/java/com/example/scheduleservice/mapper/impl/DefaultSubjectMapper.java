package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectMapper implements SubjectMapper {
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DefaultSubjectMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public SubjectDto toSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setSubject(subject.getSubject());

        if (subject.getDepartment() != null) {
            subjectDto.setDepartmentDto(departmentMapper.toDepartmentDto(subject.getDepartment()));
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

        return subject;
    }
}
