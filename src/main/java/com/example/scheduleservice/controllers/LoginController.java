package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dtoService.impl.DefaultUserDtoService;
import com.example.scheduleservice.models.AuthenticationRequest;
import com.example.scheduleservice.models.AuthenticationResponse;
import com.example.scheduleservice.services.impl.MyUserDetails;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.services.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final DefaultUserDtoService defaultUserDtoService;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, DefaultUserDtoService defaultUserDtoService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.defaultUserDtoService = defaultUserDtoService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    // Change the password
    @PutMapping("/settings")
    public String updatePassword(@AuthenticationPrincipal MyUserDetails myUserDetails,
                                 @RequestBody UpdateUserPasswordDto pojo) {
        return defaultUserDtoService.changePassword(myUserDetails, pojo.getNewPassword(),
                pojo.getNewPassword1(), pojo.getOldPassword());
    }

    // Authentication with jwt token
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }

        final UserDetails userDetails = defaultUserDtoService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
