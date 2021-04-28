package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.SubjectDto;
import com.example.scheduleservice.dto.UserDto;
import com.example.scheduleservice.entities.Subject;
import com.example.scheduleservice.entities.User;
import com.example.scheduleservice.mapper.GroupMapper;
import com.example.scheduleservice.mapper.RoleMapper;
import com.example.scheduleservice.mapper.SubjectMapper;
import com.example.scheduleservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserMapper implements UserMapper {
    private final RoleMapper roleMapper;
    private final GroupMapper groupMapper;
    private final SubjectMapper subjectMapper;

    @Autowired
    public DefaultUserMapper(RoleMapper roleMapper, GroupMapper groupMapper, SubjectMapper subjectMapper) {
        this.roleMapper = roleMapper;
        this.groupMapper = groupMapper;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        if (user.getRole() != null) {
            userDto.setRoleDto(roleMapper.toRoleDto(user.getRole()));
        }

        if (user.getGroup() != null) {
            userDto.setGroupDto(groupMapper.toGroupDto(user.getGroup()));
        }

        if (user.getSubjects().size() > 0) {
            List<SubjectDto> subjectDtos = new ArrayList<>();

            user.getSubjects().forEach(subject -> subjectDtos.add(subjectMapper.toSubjectDto(subject)));

            userDto.setSubjectDtos(subjectDtos);
        }

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        if (user.getRole() != null) {
            user.setRole(roleMapper.toRole(userDto.getRoleDto()));
        }

        if (user.getGroup() != null) {
            user.setGroup(groupMapper.toGroup(userDto.getGroupDto()));
        }

        if (userDto.getSubjectDtos().size() > 0) {
            List<Subject> subjects = new ArrayList<>();

            userDto.getSubjectDtos().forEach(subjectDto -> subjects.add(subjectMapper.toSubject(subjectDto)));

            user.setSubjects(subjects);
        }

        return user;
    }
}
