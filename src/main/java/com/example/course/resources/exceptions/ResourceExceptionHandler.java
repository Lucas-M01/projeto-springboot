package com.example.course.resources.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.course.services.exceptions.DatabaseException;
import com.example.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found"; 
        StandardError err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        
    }
}
