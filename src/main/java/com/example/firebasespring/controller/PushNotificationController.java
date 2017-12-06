package com.example.firebasespring.controller;

import com.example.firebasespring.controller.service.PushNotificationService;
import com.example.firebasespring.request.NotificationMessagesRequestDTO;
import com.example.firebasespring.response.TopicResponseExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Petya
 */
@RestController
public class PushNotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @PostMapping("/notification/messages")
    public TopicResponseExchange sendNotification(
            @RequestHeader(name = "firebase-server-key", required = true) String authKey,
            @RequestBody NotificationMessagesRequestDTO notificationMessagesRequestDTO) {
        return pushNotificationService.buildMessageAndSend(notificationMessagesRequestDTO, authKey);
    }

}
