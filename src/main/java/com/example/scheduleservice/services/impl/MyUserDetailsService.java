package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
