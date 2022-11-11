package com.AssignmentThree.Aspect;

import com.AssignmentThree.Entities.Log;
import com.AssignmentThree.Service.Implemintation.LogServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class ExecutionTimeAspect {

    final
    LogServiceImpl logService;

    @Autowired
    public ExecutionTimeAspect(LogServiceImpl logService) {
        this.logService = logService;
    }

    @Pointcut(value = "@annotation(com.AssignmentThree.Annotations.ExecutionTime)")
    public void execute() {
    }

    @Around("execute()")
    public void calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        joinPoint.proceed();
        long finish = System.nanoTime();

        Log executedJoinPoint = new Log();
        executedJoinPoint.setDurationInSeconds((finish - start) / 1000000000.0);
        executedJoinPoint.setOperation(joinPoint.getSignature().getName());
        executedJoinPoint.setData(LocalDate.now());
        logService.save(executedJoinPoint);
    }
}
