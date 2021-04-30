package com.example.scheduleservice.controllers;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
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

    @PutMapping("/profile/update_password")
    public void updatePassword(@RequestBody UpdateUserPasswordDto updateUserPasswordDto,
                               @RequestPart Long id) throws Exception {
        userDtoService.updatePassword(id, updateUserPasswordDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private List<UserDto> getAll() {
        return userDtoService.findAll();
    }

    @GetMapping("/getAllByRoleId/{roleId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private List<UserDto> getAllByRoleId(@PathVariable("roleId") Long roleId) {
        return userDtoService.findAllByRoleId(roleId);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto getById(@PathVariable("id") Long id) {
        return userDtoService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto create(@RequestBody CreateUserDto createUserDto) {
        return userDtoService.save(createUserDto);
    }

    @PostMapping("/teacher")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto createTeacher(@RequestBody CreateUserDto createUserDto) {
        return userDtoService.saveTeacher(createUserDto);
    }

    @PostMapping("/student")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto createStudent(@RequestBody CreateUserDto createUserDto) {
        return userDtoService.saveStudent(createUserDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto update(@PathVariable("id") Long id, @RequestBody UpdateUserDto updateUserDto) {
        return userDtoService.update(id, updateUserDto);
    }

    @PutMapping("/teacher/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto updateTeacher(@PathVariable("id") Long id, @RequestBody UpdateUserDto updateUserDto) {
        return userDtoService.updateTeacher(id, updateUserDto);
    }

    @PutMapping("/student/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto updateStudent(@PathVariable("id") Long id, @RequestBody UpdateUserDto updateUserDto) {
        return userDtoService.updateStudent(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void delete(@PathVariable("id") Long id) {
        userDtoService.delete(id);
    }
}