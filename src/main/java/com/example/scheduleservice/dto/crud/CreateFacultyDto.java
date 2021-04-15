package com.example.scheduleservice.dto.crud;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateFacultyDto {
    @NotNull
    private String faculty;
}
