package com.gh.employeeservice.service;

import com.gh.employeeservice.dto.DepartmentDto;
import com.gh.employeeservice.entity.Employee;
import com.gh.employeeservice.repository.EmployeeRepository;
import com.gh.errorhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    public Employee saveEmployee(Employee employee) {
        restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentId(), DepartmentDto.class);
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageFormat.format("Employee with id {0} is not found", id)));
    }
}
