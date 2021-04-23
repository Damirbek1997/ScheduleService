package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.entities.User;

public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
