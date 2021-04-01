package com.example.scheduleservice.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_name")
    private String groupName;
}
