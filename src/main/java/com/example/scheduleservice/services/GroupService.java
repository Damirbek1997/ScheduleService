package com.example.scheduleservice.services;

import com.example.scheduleservice.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    Group findById(Long id);
    Group save(Group newGroup);
    Group changeById(Long id, Group newGroup) throws Exception;
    void delete(Long id);
}
