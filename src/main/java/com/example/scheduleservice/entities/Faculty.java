package com.example.scheduleservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "faculty")
    private String faculty;
}
