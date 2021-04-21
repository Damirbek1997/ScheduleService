package com.example.scheduleservice.dtoService;

import com.example.scheduleservice.dto.GroupDto;
import com.example.scheduleservice.dto.crud.CreateGroupDto;
import com.example.scheduleservice.dto.crud.UpdateGroupDto;

import java.util.List;

public interface GroupDtoService {
    List<GroupDto> findAll();
    GroupDto findById(Long id);
    List<GroupDto> findAllByDepartmentId(Long departmentId);
    GroupDto save(CreateGroupDto createGroupDto);
    GroupDto changeById(Long id, UpdateGroupDto updateGroupDto) throws Exception;
    void delete(Long id);
}
