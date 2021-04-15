package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private String department;
    private FacultyDto facultyDto;
}
