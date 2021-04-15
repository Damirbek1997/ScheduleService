package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class CreateDepartmentDto {
    private String department;
    private Long facultyId;
}
