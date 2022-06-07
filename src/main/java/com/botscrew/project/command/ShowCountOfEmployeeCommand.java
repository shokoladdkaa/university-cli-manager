package com.botscrew.project.command;

import com.botscrew.project.model.Department;
import com.botscrew.project.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ShowCountOfEmployeeCommand implements Command {

    private final DepartmentService departmentService;

    @Override
    public void execute(List<String> variables) {
        String departmentName = variables.get(0);
        Department department = departmentService.getDepartment(departmentName);

        System.out.println(department.getLectors().size());
    }
}
