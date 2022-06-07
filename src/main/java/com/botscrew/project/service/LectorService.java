package com.botscrew.project.service;

import com.botscrew.project.model.Lector;
import com.botscrew.project.repository.LectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LectorService {

    private final LectorRepository lectorRepository;

    public List<Lector> getLectorsByNamePart(String namePart) {
        return lectorRepository.findLectorsByFirstNameAndLastNameContaining(namePart);
    }
}
