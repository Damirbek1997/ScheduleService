package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String firstName;
    private String lastName;
    private String role;
    private String faculty;
    private String department;
    private String username;
}
