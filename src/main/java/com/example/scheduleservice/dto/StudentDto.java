package com.example.scheduleservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String firstname;
    private String lastname;
    private GroupDto groupDto;
    private UserDto userDto;
    private List<SubjectDto> subjectDtos;
}
