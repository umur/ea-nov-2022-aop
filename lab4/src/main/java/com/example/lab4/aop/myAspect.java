package com.example.lab4.aop;

import com.example.lab4.entity.ActivityLog;
import com.example.lab4.exception.AopIsAwesomeHeaderException;
import com.example.lab4.repository.ActivityLogRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
public class myAspect {
    @Autowired
    private ActivityLogRepo activityLogRepo;
    @Autowired
   private  HttpServletRequest servletRequest;

@Pointcut("@annotation(com.example.lab4.annotations.ExcecutionTime)")
    public void fun1(){};

@Pointcut("execution(* com.example.lab4.controller.*.*(..))")
     public void fun2(){}


    @Before("fun2()")
    public void checkHeader(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
    if(servletRequest.getMethod().equals("GET"))
        if(servletRequest.getHeader("AOP-IS-AWESOME")==null)
            throw new AopIsAwesomeHeaderException();
    }




@Around("fun1()")
    public Object timeOfExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       System.out.println("before");
       long v1=System.nanoTime();
       System.out.println(v1);
       var result=proceedingJoinPoint.proceed();
       long v2 = System.nanoTime();
       System.out.println(v2);

       System.out.println("after");
       System.out.println(v2-v1);

       long duration =v2-v1;
       String operation=proceedingJoinPoint.getSignature().getName();
       LocalDate date= LocalDate.now();
       System.out.println(date);

       ActivityLog activityLog =new ActivityLog();

       activityLog.setDate(date.toString());
       activityLog.setDuration(duration);
       activityLog.setOperation(operation);

       activityLogRepo.save(activityLog);

    return result;
    }


}
