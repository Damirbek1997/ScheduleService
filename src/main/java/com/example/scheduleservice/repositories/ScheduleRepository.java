package com.example.scheduleservice.repositories;

import com.example.scheduleservice.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "SELECT s FROM Schedule s where s.subject.teacher.id = :teacherId and s.isDeleted = :isDeleted")
    List<Schedule> findByTeacherIdAndIsDeleted(@Param("teacherId") Long teacherId, @Param("isDeleted") Boolean isDeleted);
    List<Schedule> findAllByGroupIdAndIsDeleted(Long groupId, Boolean isDeleted);
    List<Schedule> findAllByIsDeleted(Boolean isDeleted);
    Optional<Schedule> findByIdAndIsDeleted(Long id, Boolean isDeleted);

    @Query(value = "SELECT s FROM Schedule s where s.weekDay = :weekDay and s.cabinet.subjectTime.id = :subjectTimeId")
    Schedule findByWeekDayAndSubjectTimeId(String weekDay, Long subjectTimeId);
}
