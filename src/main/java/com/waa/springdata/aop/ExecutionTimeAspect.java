package com.waa.springdata.aop;

import com.waa.springdata.entity.ActivityLog;
import com.waa.springdata.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLogService activityLogService;

    /**
     * define a reference cross-cut where this aspect can intercept
     * to take an action or advice. In  this case:
     * executionTimeAnnotation() is the pointcut
     * while all methods, of classes in the IoC, with @ExecutionTime annotation are the joinpoints
     */
    @Pointcut("@annotation(com.waa.springdata.aop.annotation.ExecutionTime)")
    public void pointCutForExecutionTimeCalc() {
    }

    @Around("pointCutForExecutionTimeCalc()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ActivityLog activityLog = new ActivityLog();
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println("Executing the method " + proceedingJoinPoint.getSignature().getName() + " took ns: " + (finish - start));
        activityLog.setDate(LocalDateTime.now());
        activityLog.setDuration((int) (finish - start));
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        this.activityLogService.save(activityLog);
        return result;
    }

}
