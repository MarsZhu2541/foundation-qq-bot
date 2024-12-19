package com.mars.foundation.service;


import com.mars.foundation.model.QqWebhookEvent;
import org.springframework.stereotype.Service;

@Service
public interface EventAckService {
    void handleEvent(QqWebhookEvent webhookEvent);
}
