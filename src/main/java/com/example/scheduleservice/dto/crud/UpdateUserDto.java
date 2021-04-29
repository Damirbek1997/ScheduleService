package com.example.scheduleservice.dto.crud;

import com.example.scheduleservice.dto.SubjectDto;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long roleId;
    private Long groupId;
    private Long teacherId;
    private UpdateTeacherDto updateTeacherDto;
    private Set<SubjectDto> subjectDtos;
}
