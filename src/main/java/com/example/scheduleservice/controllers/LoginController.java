package com.example.scheduleservice.controllers;

import com.example.scheduleservice.models.AuthenticationRequest;
import com.example.scheduleservice.models.AuthenticationResponse;
import com.example.scheduleservice.services.impl.MyUserDetails;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.services.JwtUtil;
import com.example.scheduleservice.services.impl.MyUserDetailsService;

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
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    // Change the password
    @PutMapping("/settings")
    public String updatePassword(@AuthenticationPrincipal MyUserDetails myUserDetails,
                                 @RequestBody UpdateUserPasswordDto pojo) {
        return myUserDetailsService.changePassword(myUserDetails, pojo.getNewPassword(),
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

        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
