package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.RoleDto;
import com.example.scheduleservice.dto.crud.CreateRoleDto;
import com.example.scheduleservice.dto.crud.UpdateRoleDto;
import com.example.scheduleservice.dtoService.RoleDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleDtoService roleDtoService;

    @Autowired
    public RoleController(RoleDtoService roleDtoService) {
        this.roleDtoService = roleDtoService;
    }

    @GetMapping
    private List<RoleDto> getAll() {
        return roleDtoService.findAll();
    }

    @GetMapping("/{id}")
    private RoleDto getById(@PathVariable("id") Long id) {
        return roleDtoService.findById(id);
    }

    @PostMapping
    private RoleDto create(@RequestBody CreateRoleDto createRoleDto) {
        return roleDtoService.save(createRoleDto);
    }

    @PutMapping("/{id}")
    private RoleDto change(@PathVariable("id") Long id, @RequestBody UpdateRoleDto updateRoleDto) {
        return roleDtoService.update(id, updateRoleDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        roleDtoService.delete(id);
    }
}