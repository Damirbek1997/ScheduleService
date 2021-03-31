package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.dtoService.UserDtoService;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.exceptions.InappropriatePasswordException;
import com.example.scheduleservice.mapper.UserMapper;
import com.example.scheduleservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DefaultUserDtoService implements UserDtoService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public DefaultUserDtoService(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        User createUser = new User();

        // converting to entity
        createUser.setFirstName(createUserDto.getFirstName());
        createUser.setLastName(createUserDto.getLastName());
        createUser.setUsername(createUserDto.getUsername());
//        createUser.setDepartment();
//        createUser.setFaculty();
//        createUser.setRole();

        return userMapper.toUserDto(userService.save(createUser));
    }

    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userService.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(user -> {
            UserDto userDto = userMapper.toUserDto(user);

            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toUserDto(userService.findById(id));
    }

    @Override
    public UserDto changeById (Long id, UpdateUserDto updateUserDto) throws Exception {
        User updateUser = new User();

        // converting to entity
        updateUser.setFirstName(updateUserDto.getFirstName());
        updateUser.setLastName(updateUserDto.getLastName());
        updateUser.setUsername(updateUserDto.getUsername());
//        updateUser.setDepartment();
//        updateUser.setFaculty();
//        updateUser.setRole();

        User responseUser = userService.changeById(id, updateUser);
        return userMapper.toUserDto(responseUser);
    }

    @Override
    public UserDto changeUserPassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws InappropriatePasswordException {
        User oldUser = userService.findById(id);

        String lowerCaseRegex = ".*[a-z].*";
        String upperCaseRegex = ".*[A-Z].*";
        String specSymbolRegex = ".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*";

        Pattern lowerCasePattern = Pattern.compile(lowerCaseRegex);
        Pattern upperCasePattern = Pattern.compile(upperCaseRegex);
        Pattern specSymbolPattern = Pattern.compile(specSymbolRegex);

        Matcher lowerCaseValidator = lowerCasePattern.matcher(updateUserPasswordDto.getNewPassword());
        Matcher upperCaseValidator = upperCasePattern.matcher(updateUserPasswordDto.getNewPassword());
        Matcher specSymbolValidator = specSymbolPattern.matcher(updateUserPasswordDto.getNewPassword());

        if(!updateUserPasswordDto.getOldPassword().equals(oldUser.getPassword()))
            throw new InappropriatePasswordException("Old password is incorrect!");
        else if(!updateUserPasswordDto.getNewPassword().equals(updateUserPasswordDto.getRepeatNewPassword()))
            throw new InappropriatePasswordException("New password doesn't match to repeat password!");
        else if(updateUserPasswordDto.getNewPassword().length() < 8)
            throw new InappropriatePasswordException("At least 8 characters!");
        else if(!(lowerCaseValidator.matches()))
            throw new InappropriatePasswordException("At least 1 lower case letter!");
        else if(!(upperCaseValidator.matches()))
            throw new InappropriatePasswordException("At least 1 upper case letter!");
        else if(!(specSymbolValidator.matches()))
            throw new InappropriatePasswordException("At least 1 spec symbol!");

        oldUser.setPassword(updateUserPasswordDto.getNewPassword());

        return userMapper.toUserDto(oldUser);
    }
}