package com.gh.employeeservice.feing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gh.errorhandler.exceptions.ResourceNotFoundException;
import com.gh.errorhandler.payload.ErrorDetails;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
public class CustomErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper;

    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        ErrorDetails message;
        try (InputStream bodyIs = response.body().asInputStream()) {
            message = mapper.readValue(bodyIs, ErrorDetails.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        return switch (response.status()) {
            case 404 -> new ResourceNotFoundException(message.getMessage() != null ? message.getMessage() : "Not found");
            default -> errorDecoder.decode(s, response);
        };
    }
}
