package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.DepartmentDto;
import com.example.scheduleservice.dto.crud.CreateDepartmentDto;
import com.example.scheduleservice.dto.crud.UpdateDepartmentDto;
import com.example.scheduleservice.dtoService.DepartmentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentDtoService departmentDtoService;

    @Autowired
    public DepartmentController(DepartmentDtoService departmentDtoService) {
        this.departmentDtoService = departmentDtoService;
    }

    @GetMapping
    private List<DepartmentDto> getAll() {
        return departmentDtoService.findAll();
    }

    @GetMapping("/{id}")
    private DepartmentDto getById(@PathVariable("id") Long id) {
        return departmentDtoService.findById(id);
    }

    @GetMapping("/getAllByFacultyId/{facultyId}")
    private List<DepartmentDto> getByFacultyId(@PathVariable("facultyId") Long facultyId) {
        return departmentDtoService.findByFacultyId(facultyId);
    }

    @PutMapping("/{id}")
    private DepartmentDto change(@PathVariable("id") Long id, @RequestBody UpdateDepartmentDto updateDepartmentDto) throws Exception {
        return departmentDtoService.changeById(id, updateDepartmentDto);
    }

    @PostMapping
    private DepartmentDto create(@RequestBody CreateDepartmentDto createDepartmentDto) {
        return departmentDtoService.save(createDepartmentDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        departmentDtoService.delete(id);
    }
}