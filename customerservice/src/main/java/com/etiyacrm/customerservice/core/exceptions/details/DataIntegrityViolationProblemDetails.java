package com.etiyacrm.customerservice.core.exceptions.details;

import org.springframework.http.HttpStatus;

public class DataIntegrityViolationProblemDetails extends ProblemDetails{
    public DataIntegrityViolationProblemDetails(){
        setTitle("Data Integrity Violation");
        setType("https://etiya.com/exceptions/dataintegrity");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
