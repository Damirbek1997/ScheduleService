package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "department")
    private String department;
}
