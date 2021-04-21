package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.ScheduleTimeDto;
import com.example.scheduleservice.entities.SubjectTime;
import com.example.scheduleservice.mapper.SubjectTimeMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectTImeMapper implements SubjectTimeMapper {
    @Override
    public ScheduleTimeDto toSubjectTime(SubjectTime subjectTime) {
        ScheduleTimeDto scheduleTimeDto = new ScheduleTimeDto();

        scheduleTimeDto.setId(subjectTime.getId());
        scheduleTimeDto.setStartLesson(subjectTime.getStartLesson());
        scheduleTimeDto.setEndLesson(subjectTime.getEndLesson());

        return scheduleTimeDto;
    }
}
