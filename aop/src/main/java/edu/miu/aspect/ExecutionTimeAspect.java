package edu.miu.aspect;

import edu.miu.entity.ActivityLog;
import edu.miu.repository.ActivityLogRepo;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@AllArgsConstructor
public class ExecutionTimeAspect {
    private ActivityLogRepo activityLog;
    @Pointcut("@annotation(edu.miu.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
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
