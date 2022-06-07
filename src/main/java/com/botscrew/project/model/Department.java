package com.botscrew.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", referencedColumnName="id", nullable = false)
    private University university;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Lector> lectors;

    @OneToOne
    private Lector headOfDepartment;
}
