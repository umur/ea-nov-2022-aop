package edu.miu.aspect;

import edu.miu.AopIsAwesomeException;
import edu.miu.entity.ActivityLog;
import edu.miu.repository.ActivityLogRepo;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Aspect
@Component
@AllArgsConstructor
public class ExecutionTimeAspect {
    private ActivityLogRepo activityLog;
    private HttpServletRequest servletRequest;

    @Pointcut("@annotation(edu.miu.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Pointcut("execution(*  edu.miu.controller.*.*(..))")
    public void fun2(){}

    @Before("fun2()")
    public void checkHeader(JoinPoint joinPoint) throws AopIsAwesomeException {
        if(servletRequest.getMethod().equals("GET"))
            if(servletRequest.getHeader("AOP-IS-AWESOME")==null)
                throw new AopIsAwesomeException();
    }
    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        ActivityLog ac = new ActivityLog();
        ac.setDate(LocalDateTime.now());
        ac.setOperation(proceedingJoinPoint.getSignature().getName());
        ac.setDuration(finish-start);

        activityLog.save(ac);
        return result;
    }

}
