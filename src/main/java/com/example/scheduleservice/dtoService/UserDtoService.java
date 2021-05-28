package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.exceptions.InappropriatePasswordException;

import java.util.List;

public interface UserDtoService {
    List<UserDto> findAll();
    List<UserDto> findAllByRoleId(Long roleId);
    UserDto findById(Long id);
    UserDto findByEmail(String email);
    UserDto save(CreateUserDto createUserDto);
    UserDto saveTeacher(CreateUserDto createUserDto);
    UserDto saveStudent(CreateUserDto createUserDto);
    UserDto update(UpdateUserDto updateUserDto);
    UserDto updateTeacher(Long userId, UpdateUserDto updateUserDto);
    UserDto updateStudent(Long userId, UpdateUserDto updateUserDto);
    void updatePassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws InappropriatePasswordException;
    void deleteTeacher(Long teacherId);
    void deleteStudent(Long studentId);
}
