package com.feng.baby.adapter.messaging;

import com.feng.baby.application.service.AccountApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by fengshuaiju on 17/8/23.
 */
@Slf4j
@EnableBinding(InputChannels.class)
public class ListenerForNotificationsFromUaa {

    @Autowired
    private AccountApplicationService accountApplicationService;

    @StreamListener(InputChannels.INPUT_FROM_UAA)
    public void handleNotificationsFromSelf(Notification notification) {

        log.info("Notification from uaa received: {}", notification.toString());

        try {
            EventReader eventReader = new EventReader(notification.getContent());
            switch (notification.getTypeName()) {
                case "com.feng.accounts.model.event.UserCreated": {

                    String userName = eventReader.stringValue("userName").get();
                    String nickName = eventReader.stringValue("nickName").orElse(userName);
                    accountApplicationService.createAccount(userName, nickName);
                    break;
                }
                case "com.feng.accounts.model.event.TenantApproved": {
                    String chineseName = eventReader.stringValue("chineseName").get();
                    log.info("get content info > chineseName :{}", chineseName);
                    break;
                }

                default:
                    log.debug("Unhandled notification: {}", notification.getTypeName());
                    break;
            }

        } catch (Exception e) {
            log.error("Caught exception: ", e);
        }
    }
}
