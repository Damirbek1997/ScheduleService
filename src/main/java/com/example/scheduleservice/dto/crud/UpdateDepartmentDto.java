package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateDepartmentDto {
    private Long id;
    private String department;
    private Long facultyId;
}
