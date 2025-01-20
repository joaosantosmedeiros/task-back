package com.drogas.TaskBack.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static class Output {
        private boolean status;
        private String message;

        public Output(boolean status, String message) {
            this.status = status;
            this.message = message;
        }

        public boolean isStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<Output> entityAlreadyExists(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new Output(false, exception.getMessage() + " already in use."));
    }

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<Output> entityNotFound(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Output(false, exception.getMessage() + " not found."));
    }

    @ExceptionHandler(SecurityException.class)
    private ResponseEntity<Output> unauthorized(SecurityException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Output(false, ""));
    }

}
