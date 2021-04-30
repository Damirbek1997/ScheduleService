package com.example.scheduleservice.dtoService.impl;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.dto.crud.CreateGroupDto;
import com.example.scheduleservice.dto.crud.UpdateGroupDto;
import com.example.scheduleservice.dtoService.GroupDtoService;
import com.example.scheduleservice.entities.Group;
import com.example.scheduleservice.mapper.GroupMapper;
import com.example.scheduleservice.services.DepartmentService;
import com.example.scheduleservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultGroupDtoService implements GroupDtoService {
    private final GroupMapper groupMapper;
    private final GroupService groupService;
    private final DepartmentService departmentService;

    @Autowired
    public DefaultGroupDtoService(GroupService groupService, GroupMapper groupMapper, DepartmentService departmentService) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
        this.departmentService = departmentService;
    }

    @Override
    public List<GroupDto> findAllByDepartmentId(Long departmentId) {
        List<Group> groupList = groupService.findAllByDepartmentId(departmentId);
        List<GroupDto> groupDtoList = new ArrayList<>();

        groupList.forEach(group -> {
            GroupDto groupDto = groupMapper.toGroupDto(group);

            groupDtoList.add(groupDto);
        });

        return groupDtoList;
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
    public GroupDto save(CreateGroupDto createGroupDto) {
        Group group = new Group();

        group.setGroupName(createGroupDto.getGroupName());

        if (createGroupDto.getDepartmentId() != null) {
            group.setDepartment(departmentService.findById(createGroupDto.getDepartmentId()));
        }

        return groupMapper.toGroupDto(groupService.save(group));
    }

    @Override
    public GroupDto update(Long id, UpdateGroupDto updateGroupDto) {
        Group group = groupService.findById(id);

        group.setGroupName(updateGroupDto.getGroupName());

        if (updateGroupDto.getDepartmentId() != null) {
            group.setDepartment(departmentService.findById(updateGroupDto.getDepartmentId()));
        }

        return groupMapper.toGroupDto(groupService.save(group));
    }

    @Override
    public void delete(Long id) {
        groupService.delete(id);
    }
}
