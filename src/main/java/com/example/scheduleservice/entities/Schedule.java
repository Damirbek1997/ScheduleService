package com.example.scheduleservice.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // if true - fall, false - spring
    @Column(name = "semester", nullable = false)
    private Boolean semester;

    @Column(name = "week_day", nullable = false)
    private String weekDay;

    @ManyToOne
    @NotNull
    private Subject subject;

    @ManyToOne
    @NotNull
    private SubjectTime subjectTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    @ManyToOne
    @NotNull
    private Cabinet cabinet;
}
