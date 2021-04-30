package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.crud.CreateSubjectDto;
import com.example.scheduleservice.dto.crud.UpdateSubjectDto;
import com.example.scheduleservice.dtoService.SubjectDtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectDtoService subjectDtoService;

    public SubjectController(SubjectDtoService subjectDtoService) {
        this.subjectDtoService = subjectDtoService;
    }

    @GetMapping
    private List<SubjectDto> getAll() {
        return subjectDtoService.findAll();
    }

    @GetMapping("/{id}")
    private SubjectDto getById(@PathVariable("id") Long id) {
        return subjectDtoService.findById(id);
    }

    @PutMapping("/{id}")
    private SubjectDto change(@PathVariable("id") Long id, @RequestBody UpdateSubjectDto updateSubjectDto) {
        return subjectDtoService.update(id, updateSubjectDto);
    }

    @PostMapping
    private SubjectDto create(@RequestBody CreateSubjectDto createSubjectDto) {
        return subjectDtoService.save(createSubjectDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        subjectDtoService.delete(id);
    }
}
