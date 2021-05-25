package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class ScheduleDto {
    private Long id;
    private Boolean semester;
    private String weekDay;

    private Long subjectId;
    private String subject;

    private Long teacherId;
    private String firstname;
    private String lastname;

    private Long groupId;
    private String group;

    private Long departmentId;
    private String department;

    private Long facultyId;
    private String faculty;

    private Long cabinetId;
    private String cabinet;

    private Long subjectTimeId;
    private String time;
}
