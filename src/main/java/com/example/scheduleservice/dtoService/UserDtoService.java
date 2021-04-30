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
    UserDto update(Long id, UpdateUserDto updateUserDto);
    UserDto updateTeacher(Long id, UpdateUserDto updateUserDto);
    UserDto updateStudent(Long id, UpdateUserDto updateUserDto);
    void updatePassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws InappropriatePasswordException;
    void delete(Long id);
    void deleteTeacher(Long userId, Long teacherId);
    void deleteStudent(Long userId, Long studentId);
}
