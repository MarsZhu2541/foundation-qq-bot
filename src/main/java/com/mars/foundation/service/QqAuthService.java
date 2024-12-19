package com.mars.foundation.service;

import com.mars.foundation.client.QqAuthClient;
import com.mars.foundation.config.QqBotConfig;
import com.mars.foundation.model.OpenApiToken;
import com.mars.foundation.model.QqBotAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class QqAuthService {

    @Autowired
    private QqBotConfig config;

    @Autowired
    private QqAuthClient authClient;

    private OpenApiToken apiToken;
    private Instant tokenAcquiredTime;


    public String getToken() {
        if (apiToken == null || tokenAcquiredTime.isBefore(Instant.now().minusSeconds(apiToken.getExpires_in()))) {
            apiToken = getAppAccessToken();
        }
        return apiToken.getAccess_token();
    }

    public  OpenApiToken getAppAccessToken() {
        tokenAcquiredTime = Instant.now();
        return authClient.getAppAccessToken(new QqBotAuth(config.getAppId(), config.getSecret())).getBody();
    }
}
