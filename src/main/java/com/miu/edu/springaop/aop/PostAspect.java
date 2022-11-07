package com.miu.edu.springaop.aop;

import com.miu.edu.springaop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("AOP-IS-AWESOME");
        if (header == null) {
            throw new AopIsAwesomeHeaderException("Header is null or missing.");
        }
        var result = proceedingJoinPoint.proceed();
        return result;
    }
}
