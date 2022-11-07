package com.example.eanov2022aop.aspect;

import com.example.eanov2022aop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class ServiceAspect {

    private final HttpServletRequest servletRequest;

    public ServiceAspect(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    @Pointcut("within(com.example.eanov2022aop.service.*)")
    void triggerService() {}

    @Before("triggerService()")
    void triggeredService(JoinPoint joinPoint) throws RuntimeException {
        if (Objects.equals(servletRequest.getMethod(), HttpMethod.POST.toString()) && Objects.isNull(servletRequest.getHeader("AOP-IS-AWESOME"))) {
            throw new AopIsAwesomeHeaderException();
        }
    }
}
