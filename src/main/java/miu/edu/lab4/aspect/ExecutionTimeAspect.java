package miu.edu.lab4.aspect;

import miu.edu.lab4.entity.ActivityLog;
import miu.edu.lab4.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLogService activityLogService;



    @Pointcut("@annotation(miu.edu.lab4.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        ActivityLog al = new ActivityLog();
        al.setOperation(proceedingJoinPoint.getSignature().getName());
        al.setDate(new Date());
        al.setId(1);
        al.setDuration(finish - start);

        activityLogService.addActivityLog(al);
        //System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        return result;
    }

}
