package com.gh.departmentservice.mapper;

import com.gh.departmentservice.dto.DepartmentDto;
import com.gh.departmentservice.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {

    public DepartmentDto toDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .departmentCode(department.getDepartmentCode())
                .build();
    }

    public Department toEntity(DepartmentDto dto) {
        Department department = new Department();
        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentDescription(dto.getDepartmentDescription());
        department.setDepartmentCode(dto.getDepartmentCode());

        return department;
    }
}
