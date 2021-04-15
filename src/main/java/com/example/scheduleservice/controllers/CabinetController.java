package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.dto.crud.CreateCabinetDto;
import com.example.scheduleservice.dto.crud.UpdateCabinetDto;
import com.example.scheduleservice.dtoService.CabinetDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cabinets")
public class CabinetController {
    private final CabinetDtoService cabinetDtoService;

    @Autowired
    public CabinetController(CabinetDtoService cabinetDtoService) {
        this.cabinetDtoService = cabinetDtoService;
    }

    @GetMapping
    private List<CabinetDto> getAll() {
        return cabinetDtoService.findAll();
    }

    @GetMapping("/{id}")
    private CabinetDto getById(@PathVariable("id") Long id) {
        return cabinetDtoService.findById(id);
    }

    @PutMapping("/{id}")
    private CabinetDto change(@PathVariable("id") Long id, @RequestBody UpdateCabinetDto updateCabinetDto) throws Exception {
        return cabinetDtoService.changeById(id, updateCabinetDto);
    }

    @PostMapping
    private CabinetDto create(@RequestBody CreateCabinetDto createCabinetDto) {
        return cabinetDtoService.save(createCabinetDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        cabinetDtoService.delete(id);
    }
}