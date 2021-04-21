package com.example.scheduleservice.dto.crud;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateGroupDto {
    @NotNull
    private String groupName;
    @NotNull
    private Long departmentId;
}
