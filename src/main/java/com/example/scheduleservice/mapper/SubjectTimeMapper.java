package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.SubjectTimeDto;
import com.example.scheduleservice.entities.SubjectTime;

public interface SubjectTimeMapper {
    SubjectTimeDto toSubjectTime(SubjectTime subjectTime);
}
