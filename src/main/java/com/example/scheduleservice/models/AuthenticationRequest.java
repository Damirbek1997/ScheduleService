package com.example.scheduleservice.models;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}