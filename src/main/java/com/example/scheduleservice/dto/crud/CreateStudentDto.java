package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateStudentDto {
    private String firstname;
    private String lastname;

    @NotNull
    private Long groupId;

    @NotNull
    private Long userId;

    private List<SubjectDto> subjectDtos;
}
