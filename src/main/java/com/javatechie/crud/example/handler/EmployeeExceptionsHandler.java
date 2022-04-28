package com.javatechie.crud.example.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class EmployeeExceptionsHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription=ex.toString();

        EmployeeErrorMessage employeeErrorMessage = new EmployeeErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(employeeErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription=ex.toString();

        EmployeeErrorMessage employeeErrorMessage = new EmployeeErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(employeeErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    protected ResponseEntity<Object> handleNullPointerException(UserServiceException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription=ex.toString();

        EmployeeErrorMessage employeeErrorMessage = new EmployeeErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(employeeErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription=ex.toString();

        EmployeeErrorMessage employeeErrorMessage = new EmployeeErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(employeeErrorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
