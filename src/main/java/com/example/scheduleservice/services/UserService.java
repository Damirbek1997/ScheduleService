package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByEmail(String email);
    User save(User user);
    User changeById (Long id, User user) throws Exception;
    void deleteById(Long id);
}
