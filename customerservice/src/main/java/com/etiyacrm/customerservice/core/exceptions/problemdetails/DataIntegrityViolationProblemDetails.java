package com.etiyacrm.customerservice.core.exceptions.problemdetails;

import org.springframework.http.HttpStatus;

public class DataIntegrityViolationProblemDetails extends ProblemDetails{
    public DataIntegrityViolationProblemDetails(){
        setTitle("Data Integrity Violation");
        setType("http://etiya.com/exceptions/dataintegrity");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
