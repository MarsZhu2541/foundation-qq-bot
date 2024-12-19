package com.mars.foundation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.foundation.exception.QqBotException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

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