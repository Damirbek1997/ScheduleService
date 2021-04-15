package com.example.scheduleservice.dto.crud;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateDepartmentDto {
    @NotNull
    private String department;
    @NotNull
    private Long facultyId;
}
