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
                    users.setFirstName(newUser.getFirstName());
                    users.setLastName(newUser.getLastName());
                    users.setEmail(newUser.getEmail());
                    users.setGroup(newUser.getGroup());
                    users.setRole(newUser.getRole());
                    users.setDepartment(newUser.getDepartment());
                    users.setSubjectSet(newUser.getSubjectSet());

                    return userRepository.save(users);
                }).orElseThrow(Exception::new);
    }

    // Change user password
    public String changePassword(MyUserDetails myUserDetails, String newPassword, String newPassword1, String oldPassword) {
        if (oldPassword.equals(myUserDetails.getPassword())) {
            if (oldPassword.equals(newPassword)) {
                return "New password cannot be the same as the old";
            } else if (!newPassword.equals(newPassword1)) {
                return "Passwords mismatches";
            } else if (newPassword.length() < 8) {
                return "New password too short";
            } else if (!newPassword.matches(".*")) {
                return "New password must contain at least 1 number";
            } else {
                User user = userRepository.findById(myUserDetails.getUserDetails().getId())
                        .orElseThrow(() -> new UsernameNotFoundException("Not found: " + myUserDetails.getUsername()));
                user.setPassword(newPassword);

                userRepository.save(user);
                return "Password has been successfully changed";
            }
        } else {
            return "Password is wrong";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));

        return user.map(MyUserDetails::new).get();
    }
}