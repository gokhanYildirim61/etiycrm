package com.etiyacrm.customerservice.core.exceptions.detaiils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;


    @AllArgsConstructor
    @Data
    public class ValidationProblemDetails extends ProblemDetails{
        public ValidationProblemDetails(){
            setTitle("Validation Rule Violation");
            setDetail("Validation Problem");
            setType("http://etiya.com/exceptions/validation");
            setStatus(HttpStatus.BAD_REQUEST.toString());
        }

        private List<Map<String, String>> errors;
    }

