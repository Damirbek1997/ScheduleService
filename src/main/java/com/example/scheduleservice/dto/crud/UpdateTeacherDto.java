package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateTeacherDto {
    private List<SubjectDto> subjectDtos;
}
