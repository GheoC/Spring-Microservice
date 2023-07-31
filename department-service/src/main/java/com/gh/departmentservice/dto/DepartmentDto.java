package com.gh.departmentservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartmentDto {

    private Integer id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
