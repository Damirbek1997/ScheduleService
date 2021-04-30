package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.entities.Role;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserMapper implements UserMapper {
    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());

        if (user.getRole() != null) {
            userDto.setRoleId(user.getRole().getId());
            userDto.setRole(user.getRole().getRole());
        }

        if (user.getStudent() != null) {
            userDto.setStudentId(user.getStudent().getId());
            userDto.setFirstname(user.getStudent().getFirstname());
            userDto.setLastname(user.getStudent().getLastname());

            userDto.setGroupId(user.getStudent().getGroup().getId());
            userDto.setGroup(user.getStudent().getGroup().getGroupName());

            userDto.setDepartmentId(user.getStudent().getGroup().getDepartment().getId());
            userDto.setDepartment(user.getStudent().getGroup().getDepartment().getDepartment());

            userDto.setFacultyId(user.getStudent().getGroup().getDepartment().getFaculty().getId());
            userDto.setFaculty(user.getStudent().getGroup().getDepartment().getFaculty().getFaculty());
        }

        if (user.getTeacher() != null) {
            userDto.setTeacherId(user.getTeacher().getId());
            userDto.setFirstname(user.getTeacher().getFirstname());
            userDto.setLastname(user.getTeacher().getLastname());
        }

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());

        if (user.getRole() != null) {
            Role role = new Role();
            role.setId(userDto.getRoleId());
            role.setRole(userDto.getRole());

            user.setRole(role);
        }

        return user;
    }
}
