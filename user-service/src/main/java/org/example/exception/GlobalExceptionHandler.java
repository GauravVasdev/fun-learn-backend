package org.example.exception;

import io.micrometer.core.ipc.http.HttpSender;
import org.example.exception.response.GlobalExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GlobalExceptionResponse> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(globalExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
