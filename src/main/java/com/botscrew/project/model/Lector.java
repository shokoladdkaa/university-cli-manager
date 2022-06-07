package com.botscrew.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "lector")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Department> departments;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Degree degree;
}
