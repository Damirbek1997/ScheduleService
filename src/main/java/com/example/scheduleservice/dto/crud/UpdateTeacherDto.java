package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateTeacherDto {
    private Long teacherId;
    private String firstname;
    private String lastname;
}
