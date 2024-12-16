package com.mars.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.exception.QqBotException;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class QqOpenApiErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        try {
            return toGenericErrorJson(response.body().asInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private QqBotException toGenericErrorJson(InputStream responseBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, QqBotException.class);
    }
}