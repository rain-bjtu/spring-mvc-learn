package com.rain.learn.sms.service;

import com.rain.learn.sms.ebo.GroupEbo;

public interface GroupService {

    void save(GroupEbo group);

    void delete(GroupEbo group);

    void delete(int id);

    GroupEbo get(int id);

    GroupEbo get(String name);
}
