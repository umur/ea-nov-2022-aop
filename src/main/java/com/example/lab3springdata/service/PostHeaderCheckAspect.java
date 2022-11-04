package com.example.lab3springdata.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostHeaderCheckAspect {
    private final HttpServletRequest request;

    public PostHeaderCheckAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Pointcut("within(com.example.lab3springdata.service.*)")
    public void a(){}

    @Before("a()")
    public void logActivity() throws AopIsAwesomeHeaderException{
        if (!request.getMethod().equals("POST")){
            return;
        }
        //if POST request, code below should be executed
        String header = request.getHeader("AOP-IS-AWESOME");
        if (header == null){
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing");
        }
    }

}
