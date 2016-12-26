package com.rain.learn.sms.dao;

import com.rain.learn.sms.ebo.TokenEbo;

public interface TokenDao {

    void save(TokenEbo token);

    void delete(TokenEbo token);

    void deleteByKey(String series);

    TokenEbo loadByKey(String series);

    TokenEbo getByKey(String series);
}
