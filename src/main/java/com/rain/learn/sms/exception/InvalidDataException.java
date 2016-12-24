package com.rain.learn.sms.exception;

public class InvalidDataException extends Exception {
    private static final long serialVersionUID = 5406010522148699970L;

    public InvalidDataException() {
        super();
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
