package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.StudentDto;
import com.example.scheduleservice.dtoService.StudentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentDtoService studentDtoService;

    @Autowired
    public StudentController(StudentDtoService studentDtoService) {
        this.studentDtoService = studentDtoService;
    }

    @GetMapping("/getAllByGroupId/{groupId}")
    private List<StudentDto> getAllByGroupId(@PathVariable("groupId") Long groupId) {
        return studentDtoService.findAllByGroupId(groupId);
    }

    @GetMapping
    private List<StudentDto> getAll() {
        return studentDtoService.findAll();
    }

    @GetMapping("/{id}")
    private StudentDto getById(@PathVariable("id") Long id) {
        return studentDtoService.findById(id);
    }
}