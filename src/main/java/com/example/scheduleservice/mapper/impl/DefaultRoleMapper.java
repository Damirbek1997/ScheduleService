package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.RoleDto;
import com.example.scheduleservice.entities.Role;
import com.example.scheduleservice.mapper.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoleMapper implements RoleMapper {
    @Override
    public RoleDto toRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();

        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());

        return roleDto;
    }

    @Override
    public Role toRole(RoleDto roleDto) {
        Role role = new Role();

        role.setId(roleDto.getId());
        role.setRole(roleDto.getRole());

        return role;
    }
}
