package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private GroupDto groupDto;
    private RoleDto roleDto;
    private DepartmentDto departmentDto;
}
