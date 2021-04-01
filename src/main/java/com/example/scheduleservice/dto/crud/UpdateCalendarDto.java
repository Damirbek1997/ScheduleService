package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateCalendarDto {
    private Long semesterId;
    private Long weekDay;
    private String weekDayName;
    private Long lessonId;
    private String lessonTime;
}
