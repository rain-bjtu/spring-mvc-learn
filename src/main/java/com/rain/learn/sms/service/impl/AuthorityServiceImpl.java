package com.rain.learn.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.AuthorityDao;
import com.rain.learn.sms.ebo.AuthorityEbo;
import com.rain.learn.sms.service.AuthorityService;

@Service("authorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public void save(AuthorityEbo authority) {
        authorityDao.save(authority);
    }

    @Override
    public void delete(AuthorityEbo authority) {
        authorityDao.delete(authority);
    }

    @Override
    public void delete(int id) {
        authorityDao.deleteByKey(id);
    }

    @Override
    public AuthorityEbo get(int id) {
        return authorityDao.getByKey(id);
    }

    @Override
    public AuthorityEbo get(String authority) {
        return authorityDao.queryByName(authority);
    }

}
