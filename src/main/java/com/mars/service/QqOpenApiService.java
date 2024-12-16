package com.mars.service;

import com.mars.client.QqOpenApiClient;
import com.mars.model.Media;
import com.mars.model.Message;
import com.mars.model.UploadedMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class QqOpenApiService {

    @Autowired
    private QqOpenApiClient qqOpenApiClient;

    public void sendGroupMessage(String group_openid, Message message) {
        qqOpenApiClient.sendGroupMessage(group_openid, message);
    }

    public ResponseEntity<UploadedMedia> uploadMedia(String group_openid, Media media) {
        return qqOpenApiClient.sendGroupFiles(group_openid, media);
    }
}
