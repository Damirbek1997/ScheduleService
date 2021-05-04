package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByTeacherIdAndIsDeleted(Long teacherId, Boolean isDeleted);
    List<Subject> findAllByDepartmentIdAndIsDeleted(Long departmentId, Boolean isDeleted);
    List<Subject> findAllByIsDeleted(Boolean isDeleted);
    Optional<Subject> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}
