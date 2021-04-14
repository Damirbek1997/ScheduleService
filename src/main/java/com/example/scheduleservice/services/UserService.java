package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.services.impl.MyUserDetails;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User changeById (Long id, User newUser) throws Exception;
    String changePassword(MyUserDetails myUserDetails, String newPassword, String newPassword1, String oldPassword);
    void deleteById(Long id);
}
