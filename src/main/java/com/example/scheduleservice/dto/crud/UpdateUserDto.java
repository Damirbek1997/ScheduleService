package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateUserDto {
    private Long id;
    private String email;
    private Long roleId;
    private UpdateStudentDto updateStudentDto;
    private UpdateTeacherDto updateTeacherDto;
}
