package com.github.bootstrap.exception;

public class ValidationMessage extends RuntimeException {
    public ValidationMessage(String message) {
        super(message);
    }
}
