package com.example.scheduleservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {
    private Long id;
    private List<SubjectDto> subjectDtos;
}
