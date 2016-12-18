package com.rain.learn.sms.dao;

import java.util.List;

import com.rain.learn.sms.ebo.AuthorityEbo;

public interface AuthorityDao {

    void save(AuthorityEbo authority);

    void delete(AuthorityEbo authority);

    void deleteByKey(Integer id);

    AuthorityEbo loadByKey(Integer id);

    AuthorityEbo getByKey(Integer id);

    AuthorityEbo queryByName(String name);

    List<AuthorityEbo> queryAll();
}
