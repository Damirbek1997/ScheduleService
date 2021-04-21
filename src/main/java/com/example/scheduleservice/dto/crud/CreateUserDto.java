package com.example.scheduleservice.dto.crud;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateUserDto {
    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private Long roleId;
    private Long groupId;
}
