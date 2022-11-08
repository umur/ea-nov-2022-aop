package com.example.springaop.aop;

import com.example.springaop.aop.exceptions.AopIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class PostHeaderAspect {

    private final HttpServletRequest httpServletRequest;

    @Pointcut("execution(* com.example.springaop.services.*.*(..))")
    public void servicePostMethodPointCut() {

    }

    @Before("servicePostMethodPointCut()")
    public void servicePostMethodRestrict(final JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        if (httpServletRequest.getMethod().equals("POST")
                && httpServletRequest.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException(":( You are not sending AOP-IS-AWESOME header which is required!!");
        }
    }

}
