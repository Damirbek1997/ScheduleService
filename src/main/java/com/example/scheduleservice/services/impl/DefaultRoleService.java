package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Role;
import com.example.scheduleservice.repositories.RoleRepository;
import com.example.scheduleservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultRoleService implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with " + id + " not found!"));
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
