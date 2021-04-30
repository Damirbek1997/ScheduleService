package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
    Role save(Role role);
    void delete(Long id);
}
