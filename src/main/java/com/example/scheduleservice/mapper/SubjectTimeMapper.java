package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.ScheduleTimeDto;
import com.example.scheduleservice.entities.SubjectTime;

public interface SubjectTimeMapper {
    ScheduleTimeDto toSubjectTime(SubjectTime subjectTime);
}
