package com.rain.learn.sms.service;

import com.rain.learn.sms.ebo.UserEbo;
import com.rain.learn.sms.exception.InvalidDataException;
import com.rain.learn.sms.view.model.OldNewPassword;

public interface AccountService {

    void changePassword(OldNewPassword onPassword) throws InvalidDataException;

    boolean checkPassword(String password);

    UserEbo getCurrentUser();
}
