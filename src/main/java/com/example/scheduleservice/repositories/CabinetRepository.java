package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
}
