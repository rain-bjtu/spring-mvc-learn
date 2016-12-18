package com.rain.learn.sms.service;

import com.rain.learn.sms.ebo.AuthorityEbo;

public interface AuthorityService {

    void save(AuthorityEbo authority);

    void delete(AuthorityEbo authority);

    void delete(int id);

    AuthorityEbo get(int id);

    AuthorityEbo get(String authority);
}
