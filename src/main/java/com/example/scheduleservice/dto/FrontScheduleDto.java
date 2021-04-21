package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class FrontScheduleDto {
    private Long scheduleId;
    private Boolean semester;
    private String weekDay;
    private Long subjectId;
    private String subject;
    private Long scheduleTimeId;
    private String startLesson;
    private String endLesson;
    private Long groupId;
    private String groupName;
    private Long cabinetId;
    private String cabinet;
}
