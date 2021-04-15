package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.entities.Cabinet;

public interface CabinetMapper {
    CabinetDto toCabinetDto(Cabinet Cabinet);
}
