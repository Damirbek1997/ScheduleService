package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
    @Query(value = "SELECT c FROM Cabinet c where c.id not in (?1)")
    List<Cabinet> retrieveAllFreeCabinetsNotInList(List<Long> busyCabinets);
    List<Cabinet> findAllByCabinetAndIsDeleted(String cabinet, Boolean isDeleted);
    List<Cabinet> findAllBySubjectTimeIdAndIsDeleted(Long subjectTimeId, Boolean isDeleted);
    List<Cabinet> findAllByIsDeleted(Boolean isDeleted);
    Optional<Cabinet> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
