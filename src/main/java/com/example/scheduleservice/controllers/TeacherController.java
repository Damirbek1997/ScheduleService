package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.TeacherDto;
import com.example.scheduleservice.dto.crud.CreateTeacherDto;
import com.example.scheduleservice.dto.crud.UpdateTeacherDto;
import com.example.scheduleservice.dtoService.TeacherDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    private TeacherDto change(@PathVariable("id") Long id, @RequestBody UpdateTeacherDto updateTeacherDto) throws Exception {
        return teacherDtoService.changeById(id, updateTeacherDto);
    }

    @PostMapping
    private TeacherDto create(@RequestBody CreateTeacherDto createTeacherDto) {
        return teacherDtoService.save(createTeacherDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        teacherDtoService.deleteById(id);
    }
}
