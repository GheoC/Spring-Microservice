package com.gh.employeeservice.mapper;

import com.gh.common.mapper.base.BaseMapper;
import com.gh.employeeservice.dto.EmployeeDto;
import com.gh.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapper.class)
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDto> {

    @Override
    EmployeeDto toDto(Employee source);

    @Override
    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeDto employeeDto);
}
