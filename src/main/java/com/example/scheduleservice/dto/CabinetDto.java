package com.example.scheduleservice.dto;

import lombok.Data;

@Data
public class CabinetDto {
    private Long id;
    private String cabinet;

    private Long subjectTimeId;
    private String time;
}
