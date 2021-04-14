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

    @Column(name = "start_lesson")
    private String start_lesson;

    @Column(name = "end_lesson")
    private String endLesson;
}
