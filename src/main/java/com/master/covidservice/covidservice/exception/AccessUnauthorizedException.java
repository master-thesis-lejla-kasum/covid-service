package com.master.covidservice.covidservice.exception;

public class AccessUnauthorizedException extends RuntimeException {
    public AccessUnauthorizedException() {
        super();
    }

    public AccessUnauthorizedException(String message) {
        super(message);
    }
}
