package com.rain.learn.sms.service;

import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.model.UserAuthorityDetails;

public interface UserService {

    void save(UserEbo user);

    void delete(UserEbo user);

    void delete(int id);

    UserEbo get(int id);

    UserEbo get(String name);

    UserAuthorityDetails getUserAuthorityDetails(String name);
}
