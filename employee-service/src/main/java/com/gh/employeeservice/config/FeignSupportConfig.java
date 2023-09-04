package com.gh.employeeservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gh.employeeservice.feing.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FeignSupportConfig {

    private final ObjectMapper mapper;
    @Bean
    public ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder(mapper);
    }
}
