package com.example.eanov2022aop.aspect.annotation;

import com.example.eanov2022aop.exception.AopIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
@RequiredArgsConstructor
public class HeaderInspectorAspect {
    private final HttpServletRequest request;

    @Pointcut("within(com.example.eanov2022aop.service..*)")
    public void inspectHeader() {
    }

    @Before("inspectHeader()")
    public void calculateExecutionTime() {
        if("POST".equalsIgnoreCase(request.getMethod())) {
            String aopHeader = request.getHeader("AOP-IS-AWESOME");
            if(aopHeader == null || aopHeader.isEmpty()) {
                throw new AopIsAwesomeHeaderException ("AOP-IS-AWESOME header must be provided");
            }
        }
    }
}
