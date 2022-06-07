package com.botscrew.project.repository;

import com.botscrew.project.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("select lector from Lector lector where lector.firstName like %:name% or lector.lastName like %:name%")
    List<Lector> findLectorsByFirstNameAndLastNameContaining(String name);
}
