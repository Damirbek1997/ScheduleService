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
import com.example.scheduleservice.services.SubjectTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultCabinetDtoService implements CabinetDtoService {
    private final CabinetService cabinetService;
    private final ScheduleService scheduleService;
    private final SubjectTimeService subjectTimeService;

    @Autowired
    public DefaultCabinetDtoService(CabinetService cabinetService,
                                    ScheduleService scheduleService, SubjectTimeService subjectTimeService) {
        this.cabinetService = cabinetService;
        this.scheduleService = scheduleService;
        this.subjectTimeService = subjectTimeService;
    }

    @Override
    public List<CabinetDto> findAllFreeCabinets() {
        List<Schedule> schedules = scheduleService.findAll();
        List<CabinetDto> cabinetDtos = new ArrayList<>();
        List<Long> busyCabinets = new ArrayList<>();

        schedules.forEach(schedule -> busyCabinets.add(schedule.getCabinet().getId()));

        List<Cabinet> freeCabinets = cabinetService.findAllFreeCabinets(busyCabinets);

        freeCabinets.forEach(freeCabinet -> {
            CabinetDto groupDto = CabinetMapper.INSTANCE.toCabinetDto(freeCabinet);

            cabinetDtos.add(groupDto);
        });

        return cabinetDtos;
    }

    @Override
    public List<CabinetDto> findAll() {
        List<Cabinet> cabinets = cabinetService.findAll();
        List<CabinetDto> cabinetDtos = new ArrayList<>();

        cabinets.forEach(cabinet -> {
            CabinetDto cabinetDto = CabinetMapper.INSTANCE.toCabinetDto(cabinet);

            cabinetDtos.add(cabinetDto);
        });

        return cabinetDtos;
    }

    @Override
    public CabinetDto findById(Long id) {
        return CabinetMapper.INSTANCE.toCabinetDto(cabinetService.findById(id));
    }

    @Override
    public List<CabinetDto> findAllByCabinet(String cabinet) {
        List<Cabinet> cabinets = cabinetService.findAllByCabinet(cabinet);
        List<CabinetDto> cabinetDtos = new ArrayList<>();

        cabinets.forEach(cabinet1 -> {
            CabinetDto cabinetDto = CabinetMapper.INSTANCE.toCabinetDto(cabinet1);

            cabinetDtos.add(cabinetDto);
        });

        return cabinetDtos;
    }

    @Override
    public List<CabinetDto> findAllBySubjectTimeId(Long subjectTimeId) {
        List<Cabinet> cabinets = cabinetService.findAllBySubjectTimeId(subjectTimeId);
        List<CabinetDto> cabinetDtos = new ArrayList<>();

        cabinets.forEach(cabinet1 -> {
            CabinetDto cabinetDto = CabinetMapper.INSTANCE.toCabinetDto(cabinet1);

            cabinetDtos.add(cabinetDto);
        });

        return cabinetDtos;
    }

    @Override
    public List<CabinetDto> save(CreateCabinetDto createCabinetDto) {
        List<CabinetDto> cabinetDtos = new ArrayList<>();

        for (long i = 1L; i <= 8L; i++) {
            Cabinet cabinet = new Cabinet();

            cabinet.setCabinet(createCabinetDto.getCabinet());
            cabinet.setSubjectTime(subjectTimeService.findById(i));
            cabinet.setIsDeleted(false);

            cabinetDtos.add(CabinetMapper.INSTANCE.toCabinetDto(cabinetService.save(cabinet)));
        }

        return cabinetDtos;
    }

    @Override
    public List<CabinetDto> update(UpdateCabinetDto updateCabinetDto) {
        List<Cabinet> cabinets = cabinetService.findAllByCabinet(updateCabinetDto.getCabinet());
        List<CabinetDto> cabinetDtos = new ArrayList<>();

        cabinets.forEach(cabinet -> {
            Cabinet oldCabinet = new Cabinet();

            oldCabinet.setCabinet(cabinet.getCabinet());

            cabinetDtos.add(CabinetMapper.INSTANCE.toCabinetDto(cabinetService.save(cabinet)));
        });

        return cabinetDtos;
    }

    @Override
    public void delete(String cabinet) {
        List<Cabinet> oldCabinet = cabinetService.findAllByCabinet(cabinet);

        oldCabinet.forEach(cabinet1 -> {
            cabinet1.setIsDeleted(true);

            cabinetService.save(cabinet1);
        });
    }
}
