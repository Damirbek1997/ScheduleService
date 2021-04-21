package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.ScheduleDto;
import com.example.scheduleservice.dto.crud.CreateScheduleDto;
import com.example.scheduleservice.dto.crud.UpdateScheduleDto;
import com.example.scheduleservice.dtoService.ScheduleDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleDtoService scheduleDtoService;

    @Autowired
    public ScheduleController(ScheduleDtoService scheduleDtoService) {
        this.scheduleDtoService = scheduleDtoService;
    }

    @GetMapping
    private List<ScheduleDto> getAll() {
        return scheduleDtoService.findAll();
    }

    @GetMapping("/{id}")
    private ScheduleDto getById(@PathVariable("id") Long id) {
        return scheduleDtoService.findById(id);
    }

    @GetMapping("/getAllByGroupId/{groupId}")
    private List<ScheduleDto> getAllByGroupId(@PathVariable("groupId") Long groupId) {
        return scheduleDtoService.findAllByGroupId(groupId);
    }

    @PutMapping("/{id}")
    private ScheduleDto change(@PathVariable("id") Long id, @RequestBody UpdateScheduleDto updateScheduleDto) throws Exception {
        return scheduleDtoService.changeById(id, updateScheduleDto);
    }

    @PostMapping
    private ScheduleDto create(@RequestBody CreateScheduleDto createScheduleDto) {
        return scheduleDtoService.save(createScheduleDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        scheduleDtoService.deleteById(id);
    }
}
