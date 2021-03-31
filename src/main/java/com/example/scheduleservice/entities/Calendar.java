package com.example.scheduleservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "semester_id")
    private Integer semesterId;

    @Column(name = "week_day")
    private Integer weekDay;

    @Column(name = "week_day_name")
    private String weekDayName;

    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "lesson_time")
    private String lessonTime;
}
