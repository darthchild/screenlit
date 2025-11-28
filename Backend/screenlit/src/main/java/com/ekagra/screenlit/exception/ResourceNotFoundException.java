package com.ekagra.screenlit.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("RESOURCE_NOT_FOUND: " + message);
    }
}