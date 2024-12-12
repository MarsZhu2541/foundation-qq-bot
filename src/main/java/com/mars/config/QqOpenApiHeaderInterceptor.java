package com.mars.config;

import com.mars.service.QqAuthService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QqOpenApiHeaderInterceptor implements RequestInterceptor {

    @Autowired
    private QqAuthService qqAuthService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "QQBot " + qqAuthService.getToken());
    }
}