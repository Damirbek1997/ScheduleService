package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.CabinetDto;
import com.example.scheduleservice.entities.Cabinet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CabinetMapper {
    CabinetMapper INSTANCE = Mappers.getMapper(CabinetMapper.class);

    @Mappings({
            @Mapping(source = "subjectTime.id", target = "subjectTimeId"),
            @Mapping(source = "subjectTime.time", target = "time")
    })
    CabinetDto toCabinetDto(Cabinet Cabinet);
}
