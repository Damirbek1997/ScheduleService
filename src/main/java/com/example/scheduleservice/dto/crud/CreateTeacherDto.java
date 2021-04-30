package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.UserDto;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeacherDto {
    private String firstname;
    private String lastname;

    @NotNull
    private Long userId;

    @NotNull
    private List<SubjectDto> subjectDtos;
}
