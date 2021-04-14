package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    private Group group;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Department department;

    @ManyToMany
    private Set<Subject> subjectSet;
}
