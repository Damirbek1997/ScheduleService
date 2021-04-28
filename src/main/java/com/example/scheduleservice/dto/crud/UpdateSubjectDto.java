package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateSubjectDto {
    private Long id;
    private String subject;
    private Long teacherId;
    private Long departmentId;
}
