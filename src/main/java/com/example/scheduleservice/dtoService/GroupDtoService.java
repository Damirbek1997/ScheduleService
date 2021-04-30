package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.dto.crud.CreateGroupDto;
import com.example.scheduleservice.dto.crud.UpdateGroupDto;

import java.util.List;

public interface GroupDtoService {
    List<GroupDto> findAllByDepartmentId(Long departmentId);
    List<GroupDto> findAll();
    GroupDto findById(Long id);
    GroupDto save(CreateGroupDto createGroupDto);
    GroupDto update(Long id, UpdateGroupDto updateGroupDto);
    void delete(Long id);
}
