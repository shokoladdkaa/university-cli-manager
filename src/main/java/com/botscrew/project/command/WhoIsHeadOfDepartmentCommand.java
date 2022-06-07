package com.botscrew.project.command;

import com.botscrew.project.model.Lector;
import com.botscrew.project.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class WhoIsHeadOfDepartmentCommand implements Command {

    private final DepartmentService departmentService;

    @Override
    public void execute(List<String> variables) {
        String departmentName = variables.get(0);
        Lector headOfDepartment = departmentService.getHeadOfDepartment(departmentName);
        System.out.println("Head of "
                + departmentName
                + " department is "
                + headOfDepartment.getFirstName()
                + " "
                + headOfDepartment.getLastName());
    }
}
