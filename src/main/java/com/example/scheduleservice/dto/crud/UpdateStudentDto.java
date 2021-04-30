package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateStudentDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Long groupId;
    private List<SubjectDto> subjectDtos;
}
