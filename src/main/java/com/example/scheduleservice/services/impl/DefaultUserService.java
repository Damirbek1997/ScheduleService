package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.repositories.UserRepository;
import com.example.scheduleservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with " + id + " not found!"));
    }

    @Override
    public User changeById (Long id, User newUser) throws Exception {
        return userRepository.findById(id)
                .map(users -> {
                    users.setUsername(newUser.getUsername());
                    users.setPassword(newUser.getPassword());

                    return userRepository.save(users);
                }).orElseThrow(Exception::new);
    }
}