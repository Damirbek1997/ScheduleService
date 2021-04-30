package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;

    private Long roleId;
    private String role;

    private Long teacherId;
    private Long studentId;
    private String firstname;
    private String lastname;

    private Long groupId;
    private String group;

    private Long departmentId;
    private String department;

    private Long facultyId;
    private String faculty;
}
