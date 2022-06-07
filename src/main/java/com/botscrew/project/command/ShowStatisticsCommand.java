package com.botscrew.project.command;

import com.botscrew.project.model.Degree;
import com.botscrew.project.model.Department;
import com.botscrew.project.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@AllArgsConstructor
public class ShowStatisticsCommand implements Command {

    private final DepartmentService departmentService;

    @Override
    public void execute(List<String> variables) {
        Department department = departmentService.getDepartment(variables.get(0));

        AtomicInteger assistantCount = new AtomicInteger();
        AtomicInteger associateProfessorCount = new AtomicInteger();
        AtomicInteger professorCount = new AtomicInteger();

        department.getLectors().forEach(dep -> {
            if (Degree.ASSISTANT.equals(dep.getDegree())) {
                assistantCount.getAndIncrement();
            } else if (Degree.ASSOCIATE_PROFESSOR.equals(dep.getDegree())) {
                associateProfessorCount.getAndIncrement();
            } else if (Degree.PROFESSOR.equals(dep.getDegree())) {
                professorCount.getAndIncrement();
            }
        });

        String resultTemplate = "assistants - %s. \n" +
                "        associate professors - %s\n" +
                "        professors - %s\n";

        String result = String.format(
                resultTemplate,
                assistantCount,
                associateProfessorCount,
                professorCount);

        System.out.println("Department statistics: " + result);
    }
}
