package com.rain.learn.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.rain.learn.sms.dao.AuthorityDao;
import com.rain.learn.sms.ebo.AuthorityEbo;

@Repository("authorityDao")
public class AuthorityDaoImpl extends AbstractDao<Integer, AuthorityEbo> implements AuthorityDao {

    @Override
    public AuthorityEbo queryByName(String name) {
        return queryByName(name, AuthorityEbo.AUTHORITY_PATH);
    }

}
