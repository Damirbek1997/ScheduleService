package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.FacultyDto;
import com.example.scheduleservice.dto.crud.CreateFacultyDto;
import com.example.scheduleservice.dto.crud.UpdateFacultyDto;
import com.example.scheduleservice.dtoService.FacultyDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyDtoService facultyDtoService;

    @Autowired
    public FacultyController(FacultyDtoService facultyDtoService) {
        this.facultyDtoService = facultyDtoService;
    }

    @GetMapping
    private List<FacultyDto> getAll() {
        return facultyDtoService.findAll();
    }

    @GetMapping("/{id}")
    private FacultyDto getById(@PathVariable("id") Long id) {
        return facultyDtoService.findById(id);
    }

    @PostMapping
    private FacultyDto create(@RequestBody CreateFacultyDto createFacultyDto) {
        return facultyDtoService.save(createFacultyDto);
    }

    @PutMapping("/{id}")
    private FacultyDto change(@PathVariable("id") Long id, @RequestBody UpdateFacultyDto updateFacultyDto) {
        return facultyDtoService.update(id, updateFacultyDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        facultyDtoService.delete(id);
    }
}