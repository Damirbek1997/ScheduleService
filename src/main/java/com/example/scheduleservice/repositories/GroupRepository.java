package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByDepartmentIdAndIsDeleted(Long departmentId, Boolean isDeleted);
    List<Group> findAllByIsDeleted(Boolean isDeleted);
    Optional<Group> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
