package com.example.medcloud.exception;

public class InvalidAPIKeyException extends RuntimeException {
    public InvalidAPIKeyException(String message) {
        super(message);
    }
}