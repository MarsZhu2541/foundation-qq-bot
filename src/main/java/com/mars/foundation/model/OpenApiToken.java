package com.mars.foundation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenApiToken {
    private String access_token;
    private long expires_in;
}
