package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    Group findById(Long id);
    List<Group> findAllByDepartmentId(Long departmentId);
    Group save(Group group);
    Group changeById(Long id, Group group) throws Exception;
    void delete(Long id);
}
