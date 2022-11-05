package com.example.lab3springdata.aspect;

public class AopIsAwesomeHeaderException extends RuntimeException {
    public AopIsAwesomeHeaderException(String errorMessage) {
        super(errorMessage);
    }
}
