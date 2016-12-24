package com.rain.learn.sms.service.impl;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.AuthorityEbo;
import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.model.UserAuthorityDetails;
import com.rain.learn.sms.model.UserAuthorityDetailsImpl;
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

    @Override
    public UserAuthorityDetails getUserAuthorityDetails(String name) {
        UserEbo user = userDao.queryByName(name);
        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (AuthorityEbo auth : user.getGroup().getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }
        return new UserAuthorityDetailsImpl(user.getId(), user.getName(), user.getPassword(), authorities);
    }

}
