package com.botscrew.project.command;

import com.botscrew.project.model.Department;
import com.botscrew.project.model.Lector;
import com.botscrew.project.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.OptionalDouble;

@Component
@AllArgsConstructor
public class ShowAverageSalaryCommand implements Command {

    private final DepartmentService departmentService;

    @Override
    public void execute(List<String> variables) {
        String departmentName = variables.get(0);
        Department department = departmentService.getDepartment(departmentName);

        OptionalDouble averageSalary = department.getLectors().stream()
                .mapToDouble(Lector::getSalary)
                .average();

        String resultTemplate = "The average salary of %s is %s";
        String result = String.format(resultTemplate, departmentName, averageSalary.getAsDouble());

        System.out.println(result);
    }
}
