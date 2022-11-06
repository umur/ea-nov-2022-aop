package com.example.lab3.aspect;

import com.example.lab3.model.ActivityLog;
import com.example.lab3.repository.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {

    private final ActivityLogRepo activityLogRepo;

    public ExecutionTimeAspect(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;
    }

    @Pointcut("@annotation(com.example.lab3.aspect.annotation.ExecutionTime)")
    public void a(){

    }
    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long resultDuration = finish - start;

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDuration(resultDuration);
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activityLogRepo.save(activityLog);
        return result;
    }
}
