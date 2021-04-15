package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // if true - fall, false - spring
    @Column(name = "semester")
    private Boolean semester;

    @Column(name = "week_day")
    private String weekDay;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private SubjectTime subjectTime;

    @ManyToOne
    private Group group;

    @ManyToOne
    private Cabinet cabinet;
}
