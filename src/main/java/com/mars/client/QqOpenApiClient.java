package com.mars.client;


import com.mars.model.Media;
import com.mars.model.Message;
import com.mars.model.UploadedMedia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "QqOpenApi", url = "https://api.sgroup.qq.com")
public interface QqOpenApiClient {

    @PostMapping("/v2/groups/{group_openid}/messages")
    void sendGroupMessage(@PathVariable("group_openid") String group_openid, @RequestBody Message message);

    @PostMapping("/v2/groups/{group_openid}/files")
    ResponseEntity<UploadedMedia> sendGroupFiles(@PathVariable("group_openid") String group_openid, @RequestBody Media media);

}
