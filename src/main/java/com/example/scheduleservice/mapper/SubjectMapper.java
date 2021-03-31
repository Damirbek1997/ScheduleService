package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Subject;

public interface SubjectMapper {
    SubjectDto toSubjectDto(Subject subject);
}
