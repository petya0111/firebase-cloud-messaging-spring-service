package com.example.firebasespring.request;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Petya
 */
@Getter
@Setter
public class NotificationMessagesRequestDTO {

    private String title;
    private String body;
    private String condition;
}
