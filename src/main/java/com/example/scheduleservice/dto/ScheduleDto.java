package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class ScheduleDto {
    private Long id;
    private Long groupId;
    private Long subjectId;
    private Long teacherId;
    private Long weekDay;
    private Long lessonId;
}
