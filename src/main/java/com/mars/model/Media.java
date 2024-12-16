package com.mars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Media {
    private MediaType file_type;
    private String url;
    private boolean srv_send_msg;
}


