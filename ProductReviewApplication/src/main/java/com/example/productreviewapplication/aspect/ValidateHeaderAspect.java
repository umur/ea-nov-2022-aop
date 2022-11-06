package com.example.productreviewapplication.aspect;

import com.example.productreviewapplication.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ValidateHeaderAspect {

    @Pointcut("within(com.example.productreviewapplication.service..*)")
    public void validatePointCut(){}

    @Pointcut("@annotation(com.example.productreviewapplication.aspect.annotation.ValidHeader)")
    public void annotationPointCut(){}

    @Before("annotationPointCut() && validatePointCut()")
    public void validateBefore(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {

        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        if(request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("Header is not present");
        }
    }
}
