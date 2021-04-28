package com.example.scheduleservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private GroupDto groupDto;
    private RoleDto roleDto;
    private List<SubjectDto> subjectDtos;
}
