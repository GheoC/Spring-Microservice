package com.gh.departmentservice.service;

import com.gh.departmentservice.entity.Department;
import com.gh.departmentservice.repository.DepartmentRepository;
import com.gh.errorhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageFormat.format("Department with id {0} not found", id)));
    }
}
