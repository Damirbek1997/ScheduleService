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
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "week_day")
    private Integer weekDay;

    @Column(name = "lesson_id")
    private Integer lessonId;
}
