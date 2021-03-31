package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
