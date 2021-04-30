package com.example.scheduleservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    private Teacher teacher;
}
