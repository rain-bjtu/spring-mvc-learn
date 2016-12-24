package com.rain.learn.sms.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.exception.InvalidDataException;
import com.rain.learn.sms.exception.ServiceFailedException;
import com.rain.learn.sms.service.AccountService;
import com.rain.learn.sms.service.LoginService;
import com.rain.learn.sms.util.PasswordHash;
import com.rain.learn.sms.view.model.OldNewPassword;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserDao userDao;

    @Override
    public void changePassword(OldNewPassword onPassword) throws InvalidDataException {
        UserEbo user = getCurrentUser();
        try {
            if (PasswordHash.validatePassword(onPassword.getOldPassword(), user.getPassword())) {
                String password = PasswordHash.hashPassword(onPassword.getNewPassword());
                user.setPassword(password);
                if (logger.isInfoEnabled()) {
                    logger.info("User [{}] change password successfully", user.getName());
                }
            } else {
                throw new InvalidDataException("Incorrect password");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new ServiceFailedException("Fail to change password");
        }
    }

    @Override
    public boolean checkPassword(String password) {
        UserEbo user = getCurrentUser();
        try {
            return PasswordHash.validatePassword(password, user.getPassword());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new ServiceFailedException("Fail to check password");
        }
    }

    @Override
    public UserEbo getCurrentUser() {
        int id = loginService.getLoggedInUser().getId();
        UserEbo user = userDao.getByKey(id);
        if (user == null) {
            throw new IllegalStateException("Current user doesn't exist in database.");
        }
        return user;
    }
}
