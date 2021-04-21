package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectMapper implements SubjectMapper {
    private final UserMapper userMapper;

    @Autowired
    public DefaultSubjectMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public SubjectDto toSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setSubject(subject.getSubject());

        if (subject.getTeacher() != null)
            subjectDto.setTeacherDto(userMapper.toUserDto(subject.getTeacher()));

        return subjectDto;
    }
}
