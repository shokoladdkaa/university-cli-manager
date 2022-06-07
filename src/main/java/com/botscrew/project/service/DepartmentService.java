package com.botscrew.project.service;

import com.botscrew.project.exception.DepartmentNotFoundException;
import com.botscrew.project.model.Department;
import com.botscrew.project.model.Lector;
import com.botscrew.project.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department getDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .orElseThrow(DepartmentNotFoundException::new);
    }

    public Lector getHeadOfDepartment(String departmentName) {
        return getDepartment(departmentName).getHeadOfDepartment();
    }
}
