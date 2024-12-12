package com.mars.controller;

import com.mars.config.QqBotConfig;
import com.mars.model.AuthResponse;
import com.mars.model.QqWebhookEvent;
import com.mars.service.EventAckService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;


@Slf4j
@RestController
public class WebhookController {

    @Autowired
    private QqBotConfig qqBotConfig;

    @Autowired
    private EventAckService eventAckService;

    @PostMapping("/webhook")
    public ResponseEntity<Object> handleValidation(@RequestBody QqWebhookEvent event) {

        int op = event.getOp();
        log.info("Received QQ webhook operation: {},  id: {}: ", event.getOp(), event.getId());
        switch (op) {
            case 0:
                log.info("Received QQ webhook event: {}", event.getT());
                eventAckService.handleEvent(event);
                return ResponseEntity.ok("known operation");
            case 13:
                log.info("Received QQ webhook callback validate: {}", event.getId());
                return ResponseEntity.ok(validateWebhook(event.getD().getEvent_ts(), event.getD().getPlain_token()));
            default:
                return ResponseEntity.ok("unknown operation");
        }
    }


    private AuthResponse validateWebhook(String timestamp, String plainToken) {
        // 如果secret不够长，则重复secret直到达到Ed25519种子大小（这里假设Ed25519种子大小对应32字节）
        String secret = qqBotConfig.getSecret();
        while (secret.getBytes(StandardCharsets.UTF_8).length < 32) {
            secret += secret;
        }
        secret = secret.substring(0, 32);

        // 使用seed生成私钥（这里使用Bouncy Castle库相关类模拟Ed25519密钥生成逻辑，按实际情况调整）
        Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(secret.getBytes(StandardCharsets.UTF_8));

        // 构建要签名的消息内容
        String msg = timestamp + plainToken;

        byte[] signatureBytes = generateSignature(privateKey, msg.getBytes(StandardCharsets.UTF_8));
        return new AuthResponse(plainToken, bytesToHex(signatureBytes));
    }


    private static byte[] generateSignature(Ed25519PrivateKeyParameters privateKey, byte[] msgBytes) {
        Ed25519Signer signer = new Ed25519Signer();
        signer.init(true, privateKey);
        signer.update(msgBytes, 0, msgBytes.length);
        return signer.generateSignature();
    }

    public static String bytesToHex(byte[] bytes) {
        return new BigInteger(1, bytes).toString(16);
    }
}