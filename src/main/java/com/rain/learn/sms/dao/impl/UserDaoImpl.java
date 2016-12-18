package com.rain.learn.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.UserEbo;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserEbo> implements UserDao {

    @Override
    public UserEbo queryByName(String name) {
        return queryByName(name, UserEbo.NAME_PATH);
    }

}
