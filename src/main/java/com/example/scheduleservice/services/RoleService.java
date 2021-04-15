package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
    Role save(Role role);
    Role changeById(Long id, Role role) throws Exception;
    void delete(Long id);
}
