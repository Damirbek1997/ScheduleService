package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.dto.crud.CreateCabinetDto;
import com.example.scheduleservice.dto.crud.UpdateCabinetDto;

import java.util.List;

public interface CabinetDtoService {
    List<CabinetDto> findAllFreeCabinets();
    List<CabinetDto> findAll();
    CabinetDto findById(Long id);
    CabinetDto save(CreateCabinetDto createCabinetDto);
    CabinetDto update(Long id, UpdateCabinetDto updateCabinetDto);
    void delete(Long id);
}
