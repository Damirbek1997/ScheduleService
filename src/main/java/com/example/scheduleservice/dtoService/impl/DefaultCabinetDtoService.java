package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.dto.crud.CreateCabinetDto;
import com.example.scheduleservice.dto.crud.UpdateCabinetDto;
import com.example.scheduleservice.dtoService.CabinetDtoService;
import com.example.scheduleservice.entities.Cabinet;
import com.example.scheduleservice.entities.Schedule;
import com.example.scheduleservice.mapper.CabinetMapper;
import com.example.scheduleservice.services.CabinetService;
import com.example.scheduleservice.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCabinetDtoService implements CabinetDtoService {
    private final CabinetMapper cabinetMapper;
    private final CabinetService cabinetService;
    private final ScheduleService scheduleService;

    @Autowired
    public DefaultCabinetDtoService(CabinetService cabinetService, CabinetMapper cabinetMapper, ScheduleService scheduleService) {
        this.cabinetService = cabinetService;
        this.cabinetMapper = cabinetMapper;
        this.scheduleService = scheduleService;
    }

    @Override
    public CabinetDto save(CreateCabinetDto createCabinetDto) {
        Cabinet cabinet = new Cabinet();

        // converting to entity
        cabinet.setCabinet(createCabinetDto.getCabinet());

        return cabinetMapper.toCabinetDto(cabinetService.save(cabinet));
    }

    @Override
    public void delete(Long id) {
        cabinetService.delete(id);
    }

    @Override
    public List<CabinetDto> findAll() {
        List<Cabinet> cabinets = cabinetService.findAll();
        List<CabinetDto> cabinetDtos = new ArrayList<>();

        cabinets.forEach(cabinet -> {
            CabinetDto groupDto = cabinetMapper.toCabinetDto(cabinet);

            cabinetDtos.add(groupDto);
        });

        return cabinetDtos;
    }

    @Override
    public List<CabinetDto> findAllFreeCabinets() {
        List<Schedule> schedules = scheduleService.findAll();
        List<CabinetDto> cabinetDtos = new ArrayList<>();
        List<Long> busyCabinets = new ArrayList<>();

        schedules.forEach(schedule -> {
            Long cabinetId = schedule.getCabinet().getId();

            busyCabinets.add(cabinetId);
        });

        List<Cabinet> freeCabinets = cabinetService.findAllFreeCabinets(busyCabinets);

        freeCabinets.forEach(freeCabinet -> {
            CabinetDto groupDto = cabinetMapper.toCabinetDto(freeCabinet);

            cabinetDtos.add(groupDto);
        });

        return cabinetDtos;
    }

    @Override
    public CabinetDto findById(Long id) {
        return cabinetMapper.toCabinetDto(cabinetService.findById(id));
    }

    @Override
    public CabinetDto changeById(Long id, UpdateCabinetDto updateCabinetDto) throws Exception {
        Cabinet cabinet = new Cabinet();

        // converting to entity
        cabinet.setCabinet(updateCabinetDto.getCabinet());

        return cabinetMapper.toCabinetDto(cabinetService.changeById(id, cabinet));
    }
}
