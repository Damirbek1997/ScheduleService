package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class ScheduleTimeDto {
    private Long id;
    private String startLesson;
    private String endLesson;
}
