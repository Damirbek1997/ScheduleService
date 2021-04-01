package com.example.scheduleservice.mapper;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.entities.Group;

public interface GroupMapper {
    GroupDto toGroupDto(Group group);
}
