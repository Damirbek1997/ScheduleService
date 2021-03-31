package com.example.scheduleservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/admin/home")
    public String getAdminHome() {
        return "Hello admin";
    }

    @GetMapping("/home")
    public String getHome() {
        return "Hello student";
    }
}
