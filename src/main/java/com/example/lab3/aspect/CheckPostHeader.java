package com.example.lab3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CheckPostHeader {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("within(com.example.lab3.service.*)")
    public void serviceMethods(){

    }
    @Before("serviceMethods()")
    public void checkHeader() throws AopIsAwesomeHeaderException {

        if (!httpServletRequest.getMethod().equals("POST")){
            return;
        }

        if (httpServletRequest.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME is missing");
        }
    }
}
