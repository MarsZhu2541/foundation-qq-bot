package com.mars.config;

import feign.codec.ErrorDecoder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@EnableFeignClients("com.mars.client")
@ComponentScan({"com.mars.controller", "com.mars.service"})
public class QqBotConfig {
    @Value("${openApi.appId}")
    String appId;

    @Value("${openApi.secret}")
    String secret;

    @Bean
    public QqOpenApiHeaderInterceptor qqOpenApiHeaderInterceptor() {
        return new QqOpenApiHeaderInterceptor();
    }

    @Bean
    public ErrorDecoder customErrorDecoder() {
        return new QqOpenApiErrorDecoder();
    }
}
