package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.mapper.GroupMapper;
import com.example.scheduleservice.mapper.RoleMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserMapper implements UserMapper {
    private final RoleMapper roleMapper;
    private final GroupMapper groupMapper;

    @Autowired
    public DefaultUserMapper(RoleMapper roleMapper, GroupMapper groupMapper) {
        this.roleMapper = roleMapper;
        this.groupMapper = groupMapper;
    }

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        if (user.getRole() != null)
            userDto.setRoleDto(roleMapper.toRoleDto(user.getRole()));

        if (user.getGroup() != null)
            userDto.setGroupDto(groupMapper.toGroupDto(user.getGroup()));

        return userDto;
    }
}
