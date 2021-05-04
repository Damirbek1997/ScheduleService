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

    @ManyToOne
    private Department department;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private Teacher teacher;

    @Column(name = "is_deleted", columnDefinition = "boolean default 'false'")
    private Boolean isDeleted;
}
