package com.example.scheduleservice.dto.crud;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateScheduleDto {
    @NotNull
    private Long groupId;

    @NotNull
    private Boolean semester;

    @NotNull
    private String weekDay;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long cabinetId;
}
