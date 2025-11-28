package com.ekagra.screenlit.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorResponse body = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                Instant.now()
        );
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReviewSaveException.class)
    public ResponseEntity<ErrorResponse> handleReviewSave(ReviewSaveException ex, HttpServletRequest request) {
        String message = ex.getMessage();
        if(ex.getCause() != null){
            String rootCause = ex.getCause().getClass().getSimpleName() + ": " + ex.getCause().getMessage();
            message += " | Root cause: " + rootCause;
        }

        ErrorResponse body = new ErrorResponse(
                message,
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                Instant.now()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatus(ResponseStatusException ex, HttpServletRequest request) {
        ErrorResponse body = new ErrorResponse(
                ex.getReason(),
                ex.getStatusCode().value(),
                request.getRequestURI(),
                Instant.now()
        );
        return new ResponseEntity<>(body, ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {
        ErrorResponse body = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI(),
                Instant.now()
        );
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
