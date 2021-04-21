package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
    @Query(value = "SELECT c FROM Cabinet c where c.id not in (?1)")
    List<Cabinet> retrieveFreeCabinetsNotInList(List<Long> busyCabinets);
}
