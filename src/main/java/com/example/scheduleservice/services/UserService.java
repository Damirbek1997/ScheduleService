package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findAllByRoleId(Long roleId);
    User findById(Long id);
    User findByEmail(String email);
    User save(User user);
    void delete(Long id);
}
