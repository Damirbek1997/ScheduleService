package com.example.scheduleservice.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @NotNull
    private Role role;

    @ManyToOne
    private Group group;

    @OneToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "users_subjects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;
}
