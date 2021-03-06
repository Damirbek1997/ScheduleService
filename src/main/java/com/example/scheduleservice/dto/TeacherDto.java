package com.example.scheduleservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {
    private Long id;
    private String firstname;
    private String lastname;
    private UserDto userDto;
    private List<SubjectDto> subjectDtos;
}
