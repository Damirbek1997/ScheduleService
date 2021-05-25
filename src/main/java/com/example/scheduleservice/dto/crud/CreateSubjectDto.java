package com.example.scheduleservice.dto.crud;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateSubjectDto {
    @NotNull
    private String subject;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long departmentId;
}
