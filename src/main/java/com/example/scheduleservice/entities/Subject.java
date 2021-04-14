package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @ManyToOne
    private User teacher;

    @ManyToMany
    private Set<User> userSet;
}
