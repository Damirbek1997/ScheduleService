package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.dto.UserDto;

import java.util.List;

public interface UserDtoService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto findByEmail(String email);
    UserDto save(CreateUserDto createUserDto);
    UserDto changeById (Long id, UpdateUserDto updateUserDto) throws Exception;
    void changeUserPassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws Exception;
    void deleteById(Long id);
}
