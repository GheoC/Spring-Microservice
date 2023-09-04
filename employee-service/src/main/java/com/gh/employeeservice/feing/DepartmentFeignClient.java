package com.gh.employeeservice.feing;

import com.gh.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentFeignClient {

    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartment(@PathVariable Integer id);
}
