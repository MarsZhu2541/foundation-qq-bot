package com.mars.foundation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadedMedia{
    private String file_uuid;
    private String file_info;
    private int ttl;
    private String id;
}

