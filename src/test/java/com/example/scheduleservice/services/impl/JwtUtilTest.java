package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Role;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class JwtUtilTest {
    @InjectMocks
    private JwtUtil jwtUtil;

    @Mock
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private UserRepository userRepository;

    private UserDetails userDetails;
    private String token;
    private User user;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        customUserDetailsService = new CustomUserDetailsService(userRepository);

        Role role = new Role();
        role.setId(1L);
        role.setRole("ROLE_ADMIN");
        role.setIsDeleted(false);

        user = new User();
        user.setId(1L);
        user.setRole(role);
        user.setEmail("admin");
        user.setPassword("admin");
    }

    @AfterEach
    void tearDown() {
        userDetails = null;
        token = null;
        user = null;
    }

    @Test
    void extractUsername() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(java.util.Optional.ofNullable(user));
        when(customUserDetailsService.loadUserByUsername(user.getEmail())).thenReturn(userDetails);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(java.util.Optional.ofNullable(user));
        userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());

        when(jwtUtil.generateToken(userDetails)).thenReturn(token);
        token = jwtUtil.generateToken(userDetails);

        String username = jwtUtil.extractUsername(token);

        assertEquals(username, "admin");
    }

    @Test
    void validateToken() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(java.util.Optional.ofNullable(user));
        when(customUserDetailsService.loadUserByUsername(user.getEmail())).thenReturn(userDetails);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(java.util.Optional.ofNullable(user));
        userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());

        when(jwtUtil.generateToken(userDetails)).thenReturn(token);
        token = jwtUtil.generateToken(userDetails);

        Boolean isValid = jwtUtil.validateToken(token, userDetails);

        assertEquals(isValid, true);
    }
}