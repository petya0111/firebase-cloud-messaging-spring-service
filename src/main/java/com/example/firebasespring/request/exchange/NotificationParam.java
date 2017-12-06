package com.example.firebasespring.request.exchange;

import lombok.Builder;
import lombok.Value;

/**
 *
 * @author Petya
 */
@Builder
@Value
public class NotificationParam {

    //<common>
    private String title;
    private String body;
    private String sound;
    private String click_action;
    private String body_loc_key;
    private String body_loc_args;
    private String title_loc_key;
    private String title_loc_args;
    //</common>

    //<ios>
    private String badge;
    //</ios>

    //<adnroid>
    private String icon;
    private String tag;
    private String color;
    //</android>

}
