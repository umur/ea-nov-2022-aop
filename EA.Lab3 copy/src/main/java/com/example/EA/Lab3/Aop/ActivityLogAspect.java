package com.example.EA.Lab3.Aop;

import com.example.EA.Lab3.Entity.ActivityLog;
import com.example.EA.Lab3.Service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {
    private final HttpServletRequest httpServletRequest;
    private final ActivityLogService service;

    @Pointcut("@annotation(com.example.EA.Lab3.Aop.ExecutionTime)")
    public void execTimeAnnotation(){

    }
    @Around("execTimeAnnotation()")
    public Object calculateTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        String operation = joinPoint.getSignature().getName();
        long duration = System.currentTimeMillis() - start;
        LocalDate date = LocalDate.now();
        service.save(new ActivityLog(null, date, duration, operation));
        return result;
    }

    @Pointcut("execution(* com.example.EA.Lab3.Service.*.*(..))")
    public void execPointCut(){

    }

    @Before("execPointCut()")
    public void checkMethod(JoinPoint joinPoint) throws RuntimeException{
        if(httpServletRequest.getMethod().equals("POST")){
            if(httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
                throw new AopIsAwesomeHeaderException();
            }
        }
    }


}
