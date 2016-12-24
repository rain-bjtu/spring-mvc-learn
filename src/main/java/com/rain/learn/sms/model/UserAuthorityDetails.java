package com.rain.learn.sms.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserAuthorityDetails extends UserDetails {

    int getId();
}
