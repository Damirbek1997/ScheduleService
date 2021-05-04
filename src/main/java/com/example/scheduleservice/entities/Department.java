package com.example.scheduleservice.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "department", nullable = false)
    private String department;

    @ManyToOne
    @NotNull
    private Faculty faculty;

    @Column(name = "is_deleted", columnDefinition = "boolean default 'false'")
    private Boolean isDeleted;
}
