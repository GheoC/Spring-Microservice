package com.gh.common.mapper.base;

import org.mapstruct.MapperConfig;

@MapperConfig(componentModel = "spring")
public interface BaseMapper<Entity, DTO> extends ToEntityMapper<Entity, DTO>, ToDtoMapper<Entity, DTO> {
}
