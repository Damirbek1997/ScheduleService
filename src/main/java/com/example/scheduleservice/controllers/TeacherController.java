package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.dtoService.TeacherDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherDtoService teacherDtoService;

    @Autowired
    public TeacherController(TeacherDtoService teacherDtoService) {
        this.teacherDtoService = teacherDtoService;
    }

    @GetMapping
    private List<TeacherDto> getAll() {
        return teacherDtoService.findAll();
    }

    @GetMapping("/{id}")
    private TeacherDto getById(@PathVariable("id") Long id) {
        return teacherDtoService.findById(id);
    }
}