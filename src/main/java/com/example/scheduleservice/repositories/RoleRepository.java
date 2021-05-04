package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByIsDeleted(Boolean isDeleted);
    Optional<Role> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
