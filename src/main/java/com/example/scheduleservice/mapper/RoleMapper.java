package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.RoleDto;
import com.example.scheduleservice.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring"
)
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto toRoleDto(Role role);
    Role toRole(RoleDto roleDto);
}
