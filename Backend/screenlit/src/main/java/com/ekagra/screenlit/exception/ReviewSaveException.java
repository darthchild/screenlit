package com.ekagra.screenlit.exception;

public class ReviewSaveException extends RuntimeException {
    public ReviewSaveException(String message, Throwable cause) {
        super("REVIEW_SAVE_FAILED: " + message, cause);
    }

    public ReviewSaveException(String message) {
        super("REVIEW_SAVE_FAILED: " + message);
    }
}