package com.gh.employeeservice.mapper;

import com.gh.employeeservice.dto.EmployeeDto;
import com.gh.employeeservice.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

    public Employee toEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        return employee;
    }
}
