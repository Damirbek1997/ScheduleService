package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String faculty;
    private String department;
    private String username;
}
