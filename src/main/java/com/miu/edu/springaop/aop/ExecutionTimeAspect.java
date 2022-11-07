package com.miu.edu.springaop.aop;

import com.miu.edu.springaop.entity.ActivityLog;
import com.miu.edu.springaop.service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@AllArgsConstructor
public class ExecutionTimeAspect {

    private ActivityLogService activityLogService;

    @Pointcut("@annotation(com.miu.edu.springaop.aop.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        saveActivityLog(proceedingJoinPoint.getSignature().getName(), Double.toString(((finish - start) / 1_000_000_000)));
        return result;
    }

    private void saveActivityLog(String operation, String duration) {
        ActivityLog activityLog = ActivityLog
                .builder()
                .recordedDate(LocalDate.now())
                .duration(duration)
                .operation(operation)
                .build();
        activityLogService.saveActivityLog(activityLog);
    }
}