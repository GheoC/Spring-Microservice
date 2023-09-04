package com.gh.employeeservice.service;

import com.gh.employeeservice.dto.DepartmentDto;
import com.gh.employeeservice.entity.Employee;
import com.gh.employeeservice.repository.EmployeeRepository;
import com.gh.errorhandler.exceptions.ResourceNotFoundException;
import com.gh.errorhandler.exceptions.ServiceDownException;
import com.gh.errorhandler.payload.ErrorDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    public Employee saveEmployee(Employee employee) {
//        restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentId(), DepartmentDto.class);
        webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentId())
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        response -> response.bodyToMono(ErrorDetails.class).map(errorDetails ->
                                new ResourceNotFoundException(errorDetails.getMessage())))
                .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,
                        response -> response.bodyToMono(ErrorDetails.class).map(errorDetails ->
                                new ServiceDownException(errorDetails.getMessage())))
                .bodyToMono(DepartmentDto.class)
                .block();
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                MessageFormat.format("Employee with id {0} is not found", id)));
    }
}
