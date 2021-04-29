package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.entities.Teacher;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserDto {
    private String firstName;
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private Long roleId;

    @NotNull
    private String password;
    private Long groupId;
    private CreateTeacherDto createTeacherDto;
    private List<SubjectDto> subjectDtos;
}
