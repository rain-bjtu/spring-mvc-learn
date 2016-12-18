package com.rain.learn.sms.dao;

import java.util.List;

import com.rain.learn.sms.ebo.UserEbo;

public interface UserDao {

    void save(UserEbo user);

    void delete(UserEbo user);

    void deleteByKey(Integer id);

    UserEbo loadByKey(Integer id);

    UserEbo getByKey(Integer id);

    UserEbo queryByName(String name);

    List<UserEbo> queryAll();
}
