package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.dto.crud.CreateGroupDto;
import com.example.scheduleservice.dto.crud.UpdateGroupDto;
import com.example.scheduleservice.dtoService.GroupDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupDtoService groupDtoService;

    @Autowired
    public GroupController(GroupDtoService groupDtoService) {
        this.groupDtoService = groupDtoService;
    }

    @GetMapping("/getAllByDepartmentId/{departmentId}")
    private List<GroupDto> getAllByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return groupDtoService.findAllByDepartmentId(departmentId);
    }

    @GetMapping
    private List<GroupDto> getAll() {
        return groupDtoService.findAll();
    }

    @GetMapping("/{id}")
    private GroupDto getById(@PathVariable("id") Long id) {
        return groupDtoService.findById(id);
    }

    @PostMapping
    private GroupDto create(@RequestBody CreateGroupDto createGroupDto) {
        return groupDtoService.save(createGroupDto);
    }

    @PutMapping("/{id}")
    private GroupDto change(@PathVariable("id") Long id, @RequestBody UpdateGroupDto updateGroupDto) {
        return groupDtoService.update(id, updateGroupDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        groupDtoService.delete(id);
    }
}