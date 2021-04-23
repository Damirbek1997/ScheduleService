package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dtoService.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDtoService userDtoService;

    @Autowired
    public UserController(UserDtoService userDtoService) {
        this.userDtoService = userDtoService;
    }

    @GetMapping("/profile")
    private UserDto getProfile() {
        return userDtoService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private List<UserDto> getAll() {
        return userDtoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto getById(@PathVariable("id") Long id) {
        return userDtoService.findById(id);
    }

    @GetMapping("/getAllByRole/{roleId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private List<UserDto> getAllByRoleId(@PathVariable("roleId") Long roleId) {
        return userDtoService.findAllByRoleId(roleId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto change(@PathVariable("id") Long id, @RequestBody UpdateUserDto updateUserDto) throws Exception {
        return userDtoService.changeById(id, updateUserDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto create(@RequestBody CreateUserDto createUserDto) {
        return userDtoService.save(createUserDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void delete(@PathVariable("id") Long id) {
        userDtoService.deleteById(id);
    }
}