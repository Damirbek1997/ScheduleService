package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.entities.Cabinet;
import com.example.scheduleservice.mapper.CabinetMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultCabinetMapper implements CabinetMapper {
    @Override
    public CabinetDto toCabinetDto(Cabinet cabinet) {
        CabinetDto cabinetDto = new CabinetDto();

        cabinetDto.setId(cabinet.getId());
        cabinetDto.setCabinet(cabinet.getCabinet());
        cabinetDto.setSubjectTimeId(cabinet.getSubjectTime().getId());
        cabinetDto.setTime(cabinet.getSubjectTime().getTime());

        return cabinetDto;
    }
}
