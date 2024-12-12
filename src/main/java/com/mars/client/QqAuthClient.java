package com.mars.client;

import com.mars.model.OpenApiToken;
import com.mars.model.QqBotAuth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "QqAuth", url = "https://bots.qq.com/app")
public interface QqAuthClient {

    @PostMapping("/getAppAccessToken")
    ResponseEntity<OpenApiToken> getAppAccessToken(QqBotAuth botAuth);

}
