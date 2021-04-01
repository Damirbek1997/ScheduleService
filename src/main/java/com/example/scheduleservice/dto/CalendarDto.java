package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class CalendarDto {
    private Long id;
    private Long semesterId;
    private Long weekDay;
    private String weekDayName;
    private Long lessonId;
    private String lessonTime;
}
