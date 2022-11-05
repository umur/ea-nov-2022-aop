package com.miu.edu.aop.aspect;


import com.miu.edu.aop.exception.AopIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class AwesomeHeaderAspect {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("within(com.miu.edu.aop.service..*)")
    public void awesomeHeaderAspect() {}

    @Before("awesomeHeaderAspect()")
    public void checkAwesomeHeaderAspect() {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String aopHeader = request.getHeader("AOP-IS-AWESOME");
            if (aopHeader == null || aopHeader.isBlank()) {
                throw new AopIsAwesomeHeaderException("Missing AOP-IS-AWESOME in the header");
            }
        }
    }
}
