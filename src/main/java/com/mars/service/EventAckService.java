package com.mars.service;


import com.mars.model.QqWebhookEvent;
import org.springframework.stereotype.Service;

@Service
public interface EventAckService {
    void handleEvent(QqWebhookEvent webhookEvent);
}
