package com.example.scheduleservice.dto.crud;

import lombok.Data;

@Data
public class UpdateUserPasswordDto {
    private String oldPassword;
    private String newPassword;
    private String repeatNewPassword;
}
