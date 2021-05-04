package com.example.scheduleservice.services.impl;

import com.example.scheduleservice.entities.Group;
import com.example.scheduleservice.repositories.GroupRepository;
import com.example.scheduleservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultGroupService implements GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public DefaultGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAllByDepartmentId(Long departmentId) {
        return groupRepository.findAllByDepartmentIdAndIsDeleted(departmentId, false);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAllByIsDeleted(false);
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findByIdAndIsDeleted(id, false).orElseThrow(() -> new EntityNotFoundException("Group with " + id + " not found!"));
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
