package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeacherDto {
    @NotNull
    private List<SubjectDto> subjectDtos;
}
