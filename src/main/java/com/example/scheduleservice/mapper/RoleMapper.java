package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.RoleDto;
import com.example.scheduleservice.entities.Role;

public interface RoleMapper {
    RoleDto toRoleDto(Role role);
    Role toRole(RoleDto roleDto);
}
