package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectMapper implements SubjectMapper {
    @Override
    public SubjectDto toSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setSubjectName(subject.getSubjectName());

        return subjectDto;
    }
}
