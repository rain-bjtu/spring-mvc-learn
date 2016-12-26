package com.rain.learn.sms.remember.me;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.TokenDao;
import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.TokenEbo;
import com.rain.learn.sms.ebo.UserEbo;

@Service("tokenRepository")
@Transactional
public class TokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        UserEbo user = userDao.queryByName(token.getUsername());
        tokenDao.save(new TokenEbo(token.getSeries(), user, token.getTokenValue(), token.getDate()));
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        TokenEbo token = tokenDao.loadByKey(series);
        token.setToken(tokenValue);
        token.setLastUsed(new Timestamp(lastUsed.getTime()));
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        TokenEbo token = tokenDao.loadByKey(seriesId);
        Date date = new Date(token.getLastUsed().getTime());
        return new PersistentRememberMeToken(token.getUser().getName(), seriesId, token.getToken(), date);
    }

    @Override
    public void removeUserTokens(String username) {
        UserEbo user = userDao.queryByName(username);
        for (TokenEbo token : user.getTokens()) {
            tokenDao.delete(token);
        }
    }
}
