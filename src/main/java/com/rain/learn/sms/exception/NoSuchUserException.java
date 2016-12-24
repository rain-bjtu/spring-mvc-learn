package com.rain.learn.sms.exception;

public class NoSuchUserException extends Exception {
    private static final long serialVersionUID = -5514742103919978268L;

    public NoSuchUserException() {
        super();
    }

    public NoSuchUserException(String message) {
        super(message);
    }
}
