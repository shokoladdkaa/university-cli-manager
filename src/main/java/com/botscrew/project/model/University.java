package com.botscrew.project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
