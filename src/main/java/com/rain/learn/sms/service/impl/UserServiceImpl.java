package com.rain.learn.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(UserEbo user) {
        userDao.save(user);
    }

    @Override
    public void delete(UserEbo user) {
        userDao.delete(user);
    }

    @Override
    public void delete(int id) {
        userDao.deleteByKey(id);
    }

    @Override
    public UserEbo get(int id) {
        return userDao.getByKey(id);
    }

    @Override
    public UserEbo get(String name) {
        return userDao.queryByName(name);
    }

}
