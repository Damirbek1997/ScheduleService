package com.example.scheduleservice.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cabinets")
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cabinet")
    @NotNull
    private String cabinet;

    @ManyToOne
    @NotNull
    private SubjectTime subjectTime;

    @Column(name = "is_deleted", columnDefinition = "boolean default 'false'")
    private Boolean isDeleted;
}
