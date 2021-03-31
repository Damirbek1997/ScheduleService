package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserMapper implements UserMapper {
    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
//        userDto.setDepartment();
//        userDto.setFaculty();
//        userDto.setRole();

        return userDto;
    }
}
