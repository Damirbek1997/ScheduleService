package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.dto.crud.CreateGroupDto;
import com.example.scheduleservice.dto.crud.UpdateGroupDto;
import com.example.scheduleservice.dtoService.GroupDtoService;
import com.example.scheduleservice.entities.Group;
import com.example.scheduleservice.mapper.GroupMapper;
import com.example.scheduleservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultGroupDtoService implements GroupDtoService {
    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @Autowired
    public DefaultGroupDtoService(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @Override
    public GroupDto save(CreateGroupDto createGroupDto) {
        Group group = new Group();

        // converting to entity
        group.setGroupName(createGroupDto.getGroupName());

        return groupMapper.toGroupDto(groupService.save(group));
    }

    @Override
    public void delete(Long id) {
        groupService.delete(id);
    }

    @Override
    public List<GroupDto> findAll() {
        List<Group> groupList = groupService.findAll();
        List<GroupDto> groupDtoList = new ArrayList<>();

        groupList.forEach(group -> {
            GroupDto groupDto = groupMapper.toGroupDto(group);

            groupDtoList.add(groupDto);
        });

        return groupDtoList;
    }

    @Override
    public GroupDto findById(Long id) {
        return groupMapper.toGroupDto(groupService.findById(id));
    }

    @Override
    public GroupDto changeById(Long id, UpdateGroupDto updateGroupDto) throws Exception {
        Group group = new Group();

        // converting to entity
        group.setGroupName(updateGroupDto.getGroupName());

        return groupMapper.toGroupDto(groupService.changeById(id, group));
    }
}
