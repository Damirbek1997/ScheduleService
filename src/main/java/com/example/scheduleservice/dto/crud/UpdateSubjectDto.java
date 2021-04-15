package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateSubjectDto {
    private String subject;
    private Long teacherId;
}
