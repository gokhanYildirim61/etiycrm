package com.etiyacrm.customerservice.core.exceptions.types;

public class DataIntegrityException extends InternalError{
    public DataIntegrityException(String message){
        super(message);
    }
}