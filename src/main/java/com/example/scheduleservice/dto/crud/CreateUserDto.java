package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private Long groupId;
    private Long roleId;
    private Long departmentId;
}
