package com.example.Product.Review.aspect.exception;

public class AopIsAwesomeHeaderException extends Exception {

    public AopIsAwesomeHeaderException(){}

    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }

    public AopIsAwesomeHeaderException(Exception exception) {
        super(exception);
    }
}
