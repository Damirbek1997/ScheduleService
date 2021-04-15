package com.example.scheduleservice.mapper.impl;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.entities.Group;
import com.example.scheduleservice.mapper.GroupMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultGroupMapper implements GroupMapper {
    @Override
    public GroupDto toGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();

        groupDto.setId(group.getId());
        groupDto.setGroupName(group.getGroupName());

        return groupDto;
    }
}
