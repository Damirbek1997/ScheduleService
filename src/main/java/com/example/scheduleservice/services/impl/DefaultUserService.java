package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.repositories.UserRepository;
import com.example.scheduleservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
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
    public User changeById (Long id, User user) throws Exception {
        return userRepository.findById(id)
                .map(users -> {
                    users.setFirstName(user.getFirstName());
                    users.setLastName(user.getLastName());
                    users.setEmail(user.getEmail());
                    users.setGroup(user.getGroup());
                    users.setRole(user.getRole());
                    users.setDepartment(user.getDepartment());
                    users.setSubjects(user.getSubjects());

                    return userRepository.save(users);
                }).orElseThrow(Exception::new);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));

        return user.map(MyUserDetails::new).get();
    }
}