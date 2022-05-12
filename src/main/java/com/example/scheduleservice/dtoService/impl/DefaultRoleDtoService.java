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

    @Autowired
    public DefaultRoleDtoService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleService.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();

        roles.forEach(role -> {
            RoleDto roleDto = RoleMapper.INSTANCE.toRoleDto(role);

            roleDtos.add(roleDto);
        });

        return roleDtos;
    }

    @Override
    public RoleDto findById(Long id) {
        return RoleMapper.INSTANCE.toRoleDto(roleService.findById(id));
    }

    @Override
    public RoleDto save(CreateRoleDto createRoleDto) {
        Role role = new Role();

        role.setRole(createRoleDto.getRole());
        role.setIsDeleted(false);

        return RoleMapper.INSTANCE.toRoleDto(roleService.save(role));
    }

    @Override
    public RoleDto update(Long id, UpdateRoleDto updateRoleDto) {
        Role role = roleService.findById(id);

        role.setRole(updateRoleDto.getRole());

        return RoleMapper.INSTANCE.toRoleDto(roleService.save(role));
    }

    @Override
    public void delete(Long id) {
        Role role = roleService.findById(id);

        role.setIsDeleted(true);

        roleService.save(role);
    }
}
