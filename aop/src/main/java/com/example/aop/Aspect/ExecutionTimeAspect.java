package com.example.aop.Aspect;

import com.example.aop.Service.ActivityLoggingService;
import com.example.aop.entity.ActivityLog;
import com.example.aop.exceptions.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLoggingService activityLoggingService;
    private HttpServletRequest request;

    @Autowired
    public ExecutionTimeAspect(HttpServletRequest request, ActivityLoggingService activityLoggingService) {
        this.request = request;
        this.activityLoggingService = activityLoggingService;
    }

    @Pointcut("@annotation(com.example.aop.Aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){

    }


    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("AopIsAwesomeHeaderException thrown");
        }

        long start = System.currentTimeMillis();
        var result = proceedingJoinPoint.proceed();
        long finish = System.currentTimeMillis();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);

        ActivityLog activityLog= new ActivityLog(LocalDate.now(),proceedingJoinPoint.getSignature().getName(),(finish-start));

        activityLoggingService.saveActivity(activityLog);
        return result;
    }






}

