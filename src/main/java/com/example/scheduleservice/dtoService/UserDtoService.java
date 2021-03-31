package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.exceptions.InappropriatePasswordException;

import java.util.List;

public interface UserDtoService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto save(CreateUserDto createUserDto);
    UserDto changeById (Long id, UpdateUserDto updateUserDto) throws Exception;
    UserDto changeUserPassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws InappropriatePasswordException;
    void deleteById(Long id);
}
