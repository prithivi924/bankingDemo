package com.Spring.Banking.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, String> entityNotFound (EntityNotFoundException ex){

        Map<String, String> error = new HashMap<>();
        error.put("errorMessage",ex.getMessage());

        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerNotFoundException.class)
    public Map<String, String> entityNotFound (CustomerNotFoundException ex){

        Map<String, String> error = new HashMap<>();
        error.put("errorMessage",ex.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> entityNotFound (MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
        {
            errors.put(error.getField(),error.getDefaultMessage());
        }
        );
        return errors;
    }
}
