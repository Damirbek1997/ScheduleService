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

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto update(@RequestBody UpdateUserDto updateUserDto) {
        return userDtoService.update(updateUserDto);
    }

    @PutMapping("/teacher/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto updateTeacher(@PathVariable("userId") Long userId, @RequestBody UpdateUserDto updateUserDto) {
        return userDtoService.updateTeacher(userId, updateUserDto);
    }

    @PutMapping("/student/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private UserDto updateStudent(@PathVariable("userId") Long userId, @RequestBody UpdateUserDto updateUserDto) {
        return userDtoService.updateStudent(userId, updateUserDto);
    }

    @DeleteMapping("/teacher")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void deleteTeacher(@RequestParam Long teacherId) {
        userDtoService.deleteTeacher(teacherId);
    }

    @DeleteMapping("/student")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private void deleteStudent(@RequestParam Long studentId) {
        userDtoService.deleteStudent(studentId);
    }
}