package com.example.productreviewapplication.aspect;

import com.example.productreviewapplication.model.ActivityLog;
import com.example.productreviewapplication.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService service;

    @Pointcut("@annotation(com.example.productreviewapplication.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        System.out.println("Before method execute");
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println("after");
        ActivityLog log = new ActivityLog();
        log.setDate(LocalDateTime.now());
        log.setDuration((finish - start));
        log.setOperation(proceedingJoinPoint.getSignature().getName()+"()");
        service.saveLog(log);
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        return result;
    }

}
