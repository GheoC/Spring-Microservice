package com.gh.employeeservice.mapper;

import com.gh.common.mapper.base.BaseMapper;
import com.gh.employeeservice.dto.DepartmentDto;
import com.gh.employeeservice.dto.EmployeeDto;
import com.gh.employeeservice.entity.Employee;
import com.gh.employeeservice.feing.DepartmentFeignClient;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = BaseMapper.class)
@RequiredArgsConstructor
public abstract class EmployeeMapper {

//    @Autowired
//    private RestTemplate restTemplate;

    private DepartmentFeignClient departmentFeignClient;

    @Autowired
    public void setDepartmentFeignClient(DepartmentFeignClient departmentFeignClient) {
        this.departmentFeignClient = departmentFeignClient;
    }

    @Mapping(target = "departmentDto", source = "departmentId", qualifiedByName = "getDepartmentDto")
    public abstract EmployeeDto toDto(Employee source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departmentId", source = "departmentDto.id")
    public abstract Employee toEntity(EmployeeDto employeeDto);

    @Named("getDepartmentDto")
    public DepartmentDto getDepartmentDto(Integer departmentId) {
//        return restTemplate.getForEntity("http://localhost:8080/api/departments/" + departmentId, DepartmentDto.class)
//                .getBody();
        return departmentFeignClient.getDepartment(departmentId);
    }
}
