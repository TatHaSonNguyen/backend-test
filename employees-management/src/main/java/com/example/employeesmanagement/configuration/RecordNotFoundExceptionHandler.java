package com.example.employeesmanagement.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundExceptionHandler extends RuntimeException
{
    public RecordNotFoundExceptionHandler(String exception) {
        super(exception);
    }
}
