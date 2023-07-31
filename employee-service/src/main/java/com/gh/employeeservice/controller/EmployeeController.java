package com.gh.employeeservice.controller;

import com.gh.employeeservice.dto.EmployeeDto;
import com.gh.employeeservice.mapper.EmployeeMapper;
import com.gh.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeMapper.toDto(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeMapper.toDto(employeeService.saveEmployee(employeeMapper.toEntity(employeeDto)));
    }
}
