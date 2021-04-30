package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateTeacherDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<SubjectDto> subjectDtos;
}
