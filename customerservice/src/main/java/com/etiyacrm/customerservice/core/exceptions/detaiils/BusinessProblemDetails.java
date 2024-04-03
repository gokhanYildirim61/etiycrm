package com.etiyacrm.customerservice.core.exceptions.detaiils;


import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://etiya.com/exceptions/business");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
