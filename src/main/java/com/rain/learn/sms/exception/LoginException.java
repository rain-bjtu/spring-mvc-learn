package com.rain.learn.sms.exception;

public class LoginException extends Exception {

    private static final long serialVersionUID = 7450857040606303539L;

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}
