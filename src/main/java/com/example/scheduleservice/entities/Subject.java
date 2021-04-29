package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
}
