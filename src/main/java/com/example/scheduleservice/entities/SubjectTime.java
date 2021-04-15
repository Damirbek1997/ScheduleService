package com.example.scheduleservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "schedule_time")
public class SubjectTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_lesson", nullable = false)
    private String startLesson;

    @Column(name = "end_lesson", nullable = false)
    private String endLesson;
}
