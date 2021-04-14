package com.example.scheduleservice.entities;

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
    private String cabinet;
}
