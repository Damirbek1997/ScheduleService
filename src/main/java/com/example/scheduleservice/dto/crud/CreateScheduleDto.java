package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class CreateScheduleDto {
    private Long groupId;
    private Long subjectId;
    private Long teacherId;
    private Long weekDay;
    private Long lessonId;
}
