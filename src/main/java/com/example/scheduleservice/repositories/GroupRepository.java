package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query(value = "SELECT g FROM Group g where g.department.id = :departmentId")
    List<Group> retrieveGroupsByDepartmentId(Long departmentId);
}
