package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.RoleDto;
import com.example.scheduleservice.dto.crud.CreateRoleDto;
import com.example.scheduleservice.dto.crud.UpdateRoleDto;

import java.util.List;

public interface RoleDtoService {
    List<RoleDto> findAll();
    RoleDto findById(Long id);
    RoleDto save(CreateRoleDto createRoleDto);
    RoleDto changeById(Long id, UpdateRoleDto updateRoleDto) throws Exception;
    void delete(Long id);
}
