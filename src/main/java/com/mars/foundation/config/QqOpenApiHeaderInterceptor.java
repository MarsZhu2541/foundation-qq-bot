package com.mars.foundation.config;

import com.mars.foundation.service.QqAuthService;
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