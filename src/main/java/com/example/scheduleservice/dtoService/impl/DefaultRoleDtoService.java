package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.RoleDto;
import com.example.scheduleservice.dto.crud.CreateRoleDto;
import com.example.scheduleservice.dto.crud.UpdateRoleDto;
import com.example.scheduleservice.dtoService.RoleDtoService;
import com.example.scheduleservice.entities.Role;
import com.example.scheduleservice.mapper.RoleMapper;
import com.example.scheduleservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultRoleDtoService implements RoleDtoService {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @Autowired
    public DefaultRoleDtoService(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto save(CreateRoleDto createRoleDto) {
        Role role = new Role();

        // converting to entity
        role.setRole(createRoleDto.getRole());

        return roleMapper.toRoleDto(roleService.save(role));
    }

    @Override
    public void delete(Long id) {
        roleService.delete(id);
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleService.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();

        roles.forEach(role -> {
            RoleDto roleDto = roleMapper.toRoleDto(role);

            roleDtos.add(roleDto);
        });

        return roleDtos;
    }

    @Override
    public RoleDto findById(Long id) {
        return roleMapper.toRoleDto(roleService.findById(id));
    }

    @Override
    public RoleDto changeById(Long id, UpdateRoleDto updateRoleDto) throws Exception {
        Role role = new Role();

        // converting to entity
        role.setRole(updateRoleDto.getRole());

        return roleMapper.toRoleDto(roleService.changeById(id, role));
    }
}
