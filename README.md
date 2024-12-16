# qq-bot-foundation(Webhook, Springboot)

A java foundation package for official QQ Bot(not Mirai) base on Webhook and Springboot

最近基于Mirai的实现的qq bot上线没一会就被强制下线了 遂使用官方方案 本人惯用java 于是开始造轮子
目前支持的事件类型:
```
GROUP_AT_MESSAGE_CREATE
```
后续可能会有更新

## Read qq bot guide before use this foundation
https://bot.q.qq.com/wiki/develop/api-v2/

## Project Setup

1. Add maven dependency
```
    <dependency>
        <groupId>com.mars</groupId>
        <artifactId>qq-bot-foundation</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
```
2. Add springboot configuration in application.yaml
```
openApi:
  appId: //The qqbot appid
  secret: //The qqbot secrect
```
3. Add the annotation "@Import(QqBotConfig.class)" to any spring configuration enabled class.
```
@Import(QqBotConfig.class)
@SpringBootApplication
public class QqBotChatGPTApplication {

    public static void main(String[] args) {
        SpringApplication.run(QqBotChatGPTApplication.class, args);
    }

}
```
4. Create a service to implement EventAckService
```
    @Service
    public class EventAckServiceDemo implements EventAckService {

        @Autowired
        private QqOpenApiService qqOpenApiService;
        
        @Override
        public void handleEvent(QqWebhookEvent qqWebhookEvent) {
            qqOpenApiService.sendGroupMessage(qqWebhookEvent.getD().getGroup_openid(), new Message.MessageBuilder().content("hello world").build());
        }
    }
```
## Best Practice
使用云服务ip作为webhook地址时，发现验证请求请不到程序里来，估计是腾讯设置了防火墙，遂使用ngrok内网穿透，springboot程序不使用ssl， ngrok映射springboot端口，ngrok公网地址自带https

https://download.ngrok.com/linux

## Demo
想一步到位请参考：
https://github.com/MarsZhu2541/qq-bot-chatgpt