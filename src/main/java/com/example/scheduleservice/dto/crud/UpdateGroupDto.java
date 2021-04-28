package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateGroupDto {
    private Long id;
    private String groupName;
    private Long departmentId;
}
