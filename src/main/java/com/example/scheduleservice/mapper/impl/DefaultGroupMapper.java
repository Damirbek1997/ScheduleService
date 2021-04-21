package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.entities.Group;
import com.example.scheduleservice.mapper.DepartmentMapper;
import com.example.scheduleservice.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultGroupMapper implements GroupMapper {
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DefaultGroupMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public GroupDto toGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();

        groupDto.setId(group.getId());
        groupDto.setGroupName(group.getGroupName());

        if (group.getDepartment() != null)
            groupDto.setDepartmentDto(departmentMapper.toDepartmentDto(group.getDepartment()));

        return groupDto;
    }
}
