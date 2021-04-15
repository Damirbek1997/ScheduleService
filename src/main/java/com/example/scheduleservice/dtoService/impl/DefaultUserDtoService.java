package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.crud.CreateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserDto;
import com.example.scheduleservice.dto.crud.UpdateUserPasswordDto;
import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.dtoService.UserDtoService;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.exceptions.InappropriatePasswordException;
import com.example.scheduleservice.mapper.UserMapper;
import com.example.scheduleservice.services.DepartmentService;
import com.example.scheduleservice.services.GroupService;
import com.example.scheduleservice.services.RoleService;
import com.example.scheduleservice.services.UserService;
import com.example.scheduleservice.services.impl.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DefaultUserDtoService implements UserDtoService {
    private final UserMapper userMapper;
    private final UserService userService;
    private final DefaultUserService defaultUserService;
    private final GroupService groupService;
    private final RoleService roleService;
    private final DepartmentService departmentService;

    @Autowired
    public DefaultUserDtoService(UserMapper userMapper, UserService userService, DefaultUserService defaultUserService, GroupService groupService,
                                 RoleService roleService, DepartmentService departmentService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.defaultUserService = defaultUserService;
        this.groupService = groupService;
        this.roleService = roleService;
        this.departmentService = departmentService;
    }

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        User user = new User();

        // converting to entity
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setGroup(groupService.findById(createUserDto.getGroupId()));
        user.setRole(roleService.findById(createUserDto.getRoleId()));
        user.setDepartment(departmentService.findById(createUserDto.getDepartmentId()));

        return userMapper.toUserDto(userService.save(user));
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
    public UserDetails findByEmail(String email) {
        return defaultUserService.loadUserByUsername(email);
    }

    @Override
    public UserDto changeById (Long id, UpdateUserDto updateUserDto) throws Exception {
        User user = new User();

        // converting to entity
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setEmail(updateUserDto.getEmail());

        if (updateUserDto.getGroupId() != null)
            user.setGroup(groupService.findById(updateUserDto.getGroupId()));

        if (updateUserDto.getRoleId() != null)
            user.setRole(roleService.findById(updateUserDto.getRoleId()));

        if (updateUserDto.getDepartmentId() != null)
            user.setDepartment(departmentService.findById(updateUserDto.getDepartmentId()));

        return userMapper.toUserDto(userService.changeById(id, user));
    }

    @Override
    public void changeUserPassword(Long id, UpdateUserPasswordDto updateUserPasswordDto) throws Exception {
        User user = userService.findById(id);

        String lowerCaseRegex = ".*[a-z].*";
        String upperCaseRegex = ".*[A-Z].*";
        String specSymbolRegex = ".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*";

        Pattern lowerCasePattern = Pattern.compile(lowerCaseRegex);
        Pattern upperCasePattern = Pattern.compile(upperCaseRegex);
        Pattern specSymbolPattern = Pattern.compile(specSymbolRegex);

        Matcher lowerCaseValidator = lowerCasePattern.matcher(updateUserPasswordDto.getNewPassword());
        Matcher upperCaseValidator = upperCasePattern.matcher(updateUserPasswordDto.getNewPassword());
        Matcher specSymbolValidator = specSymbolPattern.matcher(updateUserPasswordDto.getNewPassword());

        if(!updateUserPasswordDto.getOldPassword().equals(user.getPassword()))
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

        user.setPassword(updateUserPasswordDto.getNewPassword());

        userService.changeById(user.getId(), user);
    }
}