package com.example.scheduleservice.entities;

import com.sun.istack.NotNull;
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
    @NotNull
    private Boolean semester;

    @Column(name = "week_day")
    @NotNull
    private String weekDay;

    @ManyToOne
    @NotNull
    private Subject subject;

    @ManyToOne
    @NotNull
    private SubjectTime subjectTime;

    @ManyToOne
    private Group group;

    @ManyToOne
    @NotNull
    private Cabinet cabinet;
}
