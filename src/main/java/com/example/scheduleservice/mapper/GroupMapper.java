package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.entities.Group;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    @Mappings({
            @Mapping(source = "department", target = "departmentDto"),
            @Mapping(source = "department.faculty", target = "departmentDto.facultyDto")
    })
    GroupDto toGroupDto(Group group);

    @InheritInverseConfiguration
    Group toGroup(GroupDto groupDto);
}
