package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @ManyToOne
    private User teacher;
}
