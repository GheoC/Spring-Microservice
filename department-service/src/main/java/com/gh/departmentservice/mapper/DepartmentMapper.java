package com.gh.departmentservice.mapper;

import com.gh.common.mapper.base.BaseMapper;
import com.gh.departmentservice.dto.DepartmentDto;
import com.gh.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapper.class)
public interface DepartmentMapper extends BaseMapper<Department, DepartmentDto> {

    @Override
    DepartmentDto toDto(Department source);

    @Override
    @Mapping(target = "id", ignore = true)
    Department toEntity(DepartmentDto departmentDto);
}
