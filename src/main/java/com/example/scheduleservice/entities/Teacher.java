package com.example.scheduleservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    @OneToOne
    private User user;
}
