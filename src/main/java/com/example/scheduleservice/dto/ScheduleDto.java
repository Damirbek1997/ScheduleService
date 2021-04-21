package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class ScheduleDto {
    private Long id;
    private Boolean semester;
    private String weekDay;
    private SubjectDto subjectDto;
    private ScheduleTimeDto scheduleTimeDto;
    private GroupDto groupDto;
    private CabinetDto cabinetDto;
}
