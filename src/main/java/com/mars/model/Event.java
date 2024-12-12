package com.mars.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    private String plain_token;
    private String event_ts;
    private String content;
    private String id; //message id
    private String group_openid;
    private String timestamp;
    private Author author;


    @Getter
    @Setter
    public static class Author {
        private String user_openid;
    }
}