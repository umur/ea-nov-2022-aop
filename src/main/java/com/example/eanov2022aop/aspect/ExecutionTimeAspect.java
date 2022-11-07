package com.example.eanov2022aop.aspect;

import com.example.eanov2022aop.controller.ActivityLogController;
import com.example.eanov2022aop.entity.ActivityLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class ExecutionTimeAspect {

    private final ActivityLogController controller;

    public ExecutionTimeAspect(ActivityLogController controller) {
        this.controller = controller;
    }

    @Pointcut("@annotation(com.example.eanov2022aop.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();

        var log = new ActivityLog();
        log.setId(UUID.randomUUID().toString());
        log.setDate(new Date());
        log.setDuration(finish-start);
        log.setOperation(proceedingJoinPoint.getClass().getName() + "." + proceedingJoinPoint.getSignature().getName());

        controller.create(log);

        return result;
    }

}
