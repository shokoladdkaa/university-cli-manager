package com.botscrew.project.command;

import com.botscrew.project.service.LectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GlobalSearchCommand implements Command {

    private final LectorService lectorService;

    @Override
    public void execute(List<String> variables) {
        String namePart = variables.get(0);

        List<String> foundLectorsFirstAndLastName = lectorService.getLectorsByNamePart(namePart).stream()
                .map(lector -> lector.getFirstName() + " " + lector.getLastName())
                .collect(Collectors.toList());

        System.out.println(foundLectorsFirstAndLastName);
    }
}
