package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.SubjectTimeDto;
import com.example.scheduleservice.dtoService.SubjectTimeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject_times")
public class SubjectTImeController {
    private final SubjectTimeDtoService subjectTimeDtoService;

    @Autowired
    public SubjectTImeController(SubjectTimeDtoService subjectTimeDtoService) {
        this.subjectTimeDtoService = subjectTimeDtoService;
    }

    @GetMapping
    private List<SubjectTimeDto> getAll() {
        return subjectTimeDtoService.findAll();
    }

    @GetMapping("/{id}")
    private SubjectTimeDto getById(@PathVariable("id") Long id) {
        return subjectTimeDtoService.findById(id);
    }
}