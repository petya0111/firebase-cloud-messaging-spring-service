/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firebasespring.request.exchange;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

/**
 *
 * @author Petya
 */
@Builder
@Value
public class PushMessage {

    private String to;
    private Priority priority;
    private String condition;
    private List<String> registration_ids;
    private Integer time_to_live;
    private String collapse_key;
    private Boolean content_available;
    @Singular("dataItem")
    private Map<String, Object> data;
    private NotificationParam notification;
}
