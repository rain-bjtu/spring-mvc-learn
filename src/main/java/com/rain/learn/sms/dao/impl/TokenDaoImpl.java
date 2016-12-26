package com.rain.learn.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.rain.learn.sms.dao.TokenDao;
import com.rain.learn.sms.ebo.TokenEbo;

@Repository("tokenDao")
public class TokenDaoImpl extends AbstractDao<String, TokenEbo> implements TokenDao {

}
