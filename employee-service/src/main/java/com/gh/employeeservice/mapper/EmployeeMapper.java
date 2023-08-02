package com.gh.employeeservice.mapper;

import com.gh.common.mapper.base.BaseMapper;
import com.gh.employeeservice.dto.DepartmentDto;
import com.gh.employeeservice.dto.EmployeeDto;
import com.gh.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Mapper(config = BaseMapper.class)
public abstract class EmployeeMapper {

    @Autowired
    private RestTemplate restTemplate;

    @Mapping(target = "departmentDto", source = "departmentId", qualifiedByName = "getDepartmentDto")
    public abstract EmployeeDto toDto(Employee source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departmentId", source = "departmentDto.id")
    public abstract Employee toEntity(EmployeeDto employeeDto);

    @Named("getDepartmentDto")
    public DepartmentDto getDepartmentDto(Integer departmentId) {
        return restTemplate.getForEntity("http://localhost:8080/api/departments/" + departmentId, DepartmentDto.class)
                .getBody();
    }
}
