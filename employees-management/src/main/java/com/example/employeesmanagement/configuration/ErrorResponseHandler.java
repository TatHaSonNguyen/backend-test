package com.example.employeesmanagement.configuration;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Define response format for handling error
 */
@XmlRootElement(name = "error")
public class ErrorResponseHandler
{
    public ErrorResponseHandler(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    private String message;

    private List<String> details;
}
