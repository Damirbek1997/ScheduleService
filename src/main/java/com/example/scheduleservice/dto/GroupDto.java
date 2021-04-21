package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class GroupDto {
    private Long id;
    private String groupName;
    private DepartmentDto departmentDto;
}
