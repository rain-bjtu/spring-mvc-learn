package com.rain.learn.sms.exception;

public class ServiceFailedException extends RuntimeException {

    private static final long serialVersionUID = 2410543091770315989L;

    public ServiceFailedException() {
        super();
    }

    public ServiceFailedException(String message) {
        super(message);
    }
}
