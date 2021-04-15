package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class CreateScheduleDto {
    private Boolean semester;
    private String weekDay;
    private Long subjectId;
    private Long subjectTimeId;
    private Long groupId;
    private Long cabinetId;
}
