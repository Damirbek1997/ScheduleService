package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "semester_id")
    private Long semesterId;

    @Column(name = "week_day")
    private Long weekDay;

    @Column(name = "week_day_name")
    private String weekDayName;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "lesson_time")
    private String lessonTime;
}
