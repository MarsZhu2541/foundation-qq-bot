package com.mars.foundation.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QqWebhookEvent {
    private String id;
    private int op;
    private Event d;
    private int s;
    private EventType t;
}