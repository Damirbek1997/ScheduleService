package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dtoService.UserDtoService;
import com.example.scheduleservice.models.AuthenticationRequest;
import com.example.scheduleservice.models.AuthenticationResponse;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.services.CustomUserDetailsService;
import com.example.scheduleservice.services.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserDtoService userDtoService;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, UserDtoService userDtoService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.userDtoService = userDtoService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    // Change the password
    @PutMapping("/settings")
    public void updatePassword(@RequestBody UpdateUserPasswordDto updateUserPasswordDto) throws Exception {
        userDtoService.changeUserPassword(1L, updateUserPasswordDto);
    }

    // Authentication with jwt token
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
