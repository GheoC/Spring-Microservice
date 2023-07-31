package com.gh.employeeservice.service;

import com.gh.employeeservice.entity.Employee;
import com.gh.employeeservice.repository.EmployeeRepository;
import com.gh.errorhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageFormat.format("Employee with id {0} is not found", id)));
    }
}
