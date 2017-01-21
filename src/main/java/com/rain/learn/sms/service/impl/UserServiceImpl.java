package com.rain.learn.sms.service.impl;

import static com.rain.learn.sms.type.UserRole.ADMINISTRATOR;
import static com.rain.learn.sms.type.UserRole.USER;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.GroupDao;
import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.AuthorityEbo;
import com.rain.learn.sms.ebo.GroupEbo;
import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.model.UserDetailsImpl;
import com.rain.learn.sms.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;

    @Override
    public void save(UserEbo user) {
        userDao.save(user);
    }

    @Override
    public void saveAsUser(UserEbo user) {
        GroupEbo group = groupDao.queryByName(USER.getText());
        user.setGroup(group);
        userDao.save(user);
    }

    @Override
    public void saveAsAdministrator(UserEbo user) {
        GroupEbo group = groupDao.queryByName(ADMINISTRATOR.getText());
        user.setGroup(group);
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEbo user = userDao.queryByName(username);
        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (AuthorityEbo auth : user.getGroup().getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }
        return new UserDetailsImpl(user.getName(), user.getPassword(), authorities);
    }

    @Override
    public boolean exist(String name) {
        boolean result = true;
        try {
            userDao.queryByName(name);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

}
