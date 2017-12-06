package com.example.firebasespring.controller.service;

import com.example.firebasespring.request.NotificationMessagesRequestDTO;
import com.example.firebasespring.request.exchange.NotificationParam;
import com.example.firebasespring.request.exchange.PushMessage;
import com.example.firebasespring.response.TopicResponseExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Petya
 */
@Service
public class PushNotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public TopicResponseExchange buildMessageAndSend(NotificationMessagesRequestDTO dto, String authKey) {

        PushMessage buildPushMessage = buildPushMessage(dto);
        HttpEntity<PushMessage> entity = setHeaders(authKey, buildPushMessage);
        ResponseEntity<TopicResponseExchange> exchange = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, entity, TopicResponseExchange.class);
        if (exchange != null) {
            return exchange.getBody();
        }
        return null;
    }

    private PushMessage buildPushMessage(NotificationMessagesRequestDTO dto) {
        PushMessage buildPushMessage = PushMessage.builder()
                .condition(dto.getCondition())
                .notification(NotificationParam.builder().body(dto.getBody()).title(dto.getTitle()).build())
                .build();
        return buildPushMessage;
    }

    private HttpEntity<PushMessage> setHeaders(String authKey, PushMessage message) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "key=" + authKey);

        return new HttpEntity<>(message, headers);
    }

}
