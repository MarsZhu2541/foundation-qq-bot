package com.mars.foundation.model;

import lombok.Getter;

@Getter
public class Message {
    private final String content;
    private final MessageType msg_type;
    private final String event_id;
    private final String msg_id;
    private final UploadedMedia media;
    private final int msg_seq;

    private Message(MessageBuilder builder) {
        this.content = builder.content;
        this.msg_type = builder.msg_type;
        this.event_id = builder.event_id;
        this.msg_id = builder.msg_id;
        this.media = builder.media;
        this.msg_seq = builder.msg_seq;
    }

    public static class MessageBuilder {
        private String content;
        private MessageType msg_type;
        private String event_id;
        private String msg_id;
        private UploadedMedia media;
        private int msg_seq;

        public MessageBuilder content(String content) {
            this.content = content;
            return this;
        }

        public MessageBuilder msgType(MessageType msg_type) {
            this.msg_type = msg_type;
            return this;
        }

        public MessageBuilder eventId(String event_id) {
            this.event_id = event_id;
            return this;
        }

        public MessageBuilder msgId(String msg_id) {
            this.msg_id = msg_id;
            return this;
        }

        public MessageBuilder media(UploadedMedia media) {
            this.media = media;
            return this;
        }

        public MessageBuilder msgSeq(int msg_seq) {
            this.msg_seq = msg_seq;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}