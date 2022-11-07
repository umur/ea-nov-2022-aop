package com.example.Product.Review.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.*;

@Aspect
@Component
@RequiredArgsConstructor
public class AopIsAwesomeAspect {

    private final HttpServletRequest request;

    @Pointcut("within(com.example.Product.Review.service..*)")
    public void serviceMethod() {}

    @Before("serviceMethod()")
    public void checkForAopIsAwesomeHeader() {
        String requestMethod = request.getMethod();
        if (requestMethod.equals("POST")) {
            String header = request.getHeader("AOP-IS-AWESOME");
            if (null == header)
                throw new RuntimeException("AOP-IS-AWESOME is required header");
        }
    }
}
