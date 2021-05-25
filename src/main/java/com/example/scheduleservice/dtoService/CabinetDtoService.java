package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.dto.crud.CreateCabinetDto;
import com.example.scheduleservice.dto.crud.UpdateCabinetDto;

import java.util.List;

public interface CabinetDtoService {
    List<CabinetDto> findAllFreeCabinets();
    List<CabinetDto> findAllByCabinet(String cabinet);
    List<CabinetDto> findAllBySubjectTimeId(Long subjectTimeId);
    List<CabinetDto> save(CreateCabinetDto createCabinetDto);
    List<CabinetDto> update(UpdateCabinetDto updateCabinetDto);
    List<CabinetDto> findAll();
    CabinetDto findById(Long id);
    void delete(String cabinet);
}
