package com.gh.employeeservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {
    private Integer id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
