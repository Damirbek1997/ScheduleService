package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectTimeDto;
import com.example.scheduleservice.entities.SubjectTime;
import com.example.scheduleservice.mapper.SubjectTimeMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectTImeMapper implements SubjectTimeMapper {
    @Override
    public SubjectTimeDto toSubjectTime(SubjectTime subjectTime) {
        SubjectTimeDto subjectTimeDto = new SubjectTimeDto();

        subjectTimeDto.setId(subjectTime.getId());
        subjectTimeDto.setTime(subjectTime.getTime());

        return subjectTimeDto;
    }
}
