package com.gh.departmentservice.controller;

import com.gh.departmentservice.dto.DepartmentDto;
import com.gh.departmentservice.mapper.DepartmentMapper;
import com.gh.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @PostMapping("/departments")
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentMapper.toDto(departmentService.saveDepartment(departmentMapper.toEntity(departmentDto)));
    }

    @GetMapping("/departments/{id}")
    public DepartmentDto getDepartment(@PathVariable Integer id) {
        return departmentMapper.toDto(departmentService.getDepartmentById(id));
    }


}
