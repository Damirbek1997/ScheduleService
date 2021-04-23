package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class SubjectDto {
    private Long id;
    private String subject;
    private DepartmentDto departmentDto;
    private UserDto teacherDto;
}
