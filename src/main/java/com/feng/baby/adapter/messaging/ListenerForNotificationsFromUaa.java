package com.feng.baby.adapter.messaging;

import com.alibaba.fastjson.JSON;
import com.feng.baby.application.command.UserInfoUpdated;
import com.feng.baby.application.service.AccountService;
import com.feng.baby.application.service.UserService;
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
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @StreamListener(InputChannels.INPUT_FROM_UAA)
    public void handleNotificationsFromSelf(Notification notification) {

        log.info("Notification from uaa received: {}", notification.toString());

        try {
            EventReader eventReader = new EventReader(notification.getContent());
            switch (notification.getTypeName()) {
                case "com.feng.accounts.model.event.UserCreated": {

                    String userName = eventReader.stringValue("userName").get();
                    String nickName = eventReader.stringValue("nickName").orElse(userName);
                    accountService.createAccount(userName, nickName);
                    break;
                }
                case "com.feng.accounts.model.event.TenantApproved": {
                    String chineseName = eventReader.stringValue("chineseName").get();
                    log.info("get content info > chineseName :{}", chineseName);
                    break;
                }
                case "com.feng.accounts.model.event.UserInfoUpdated": {
                    UserInfoUpdated userInfoUpdated = JSON.parseObject(notification.getContent(), UserInfoUpdated.class);
                    userService.updateUserInfo(userInfoUpdated);
                    log.info("update user info", notification.getContent());
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
