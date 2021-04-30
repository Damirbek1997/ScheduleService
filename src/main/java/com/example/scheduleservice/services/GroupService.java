package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAllByDepartmentId(Long departmentId);
    List<Group> findAll();
    Group findById(Long id);
    Group save(Group group);
    void delete(Long id);
}
