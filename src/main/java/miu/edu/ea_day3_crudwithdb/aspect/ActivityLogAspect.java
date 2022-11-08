package miu.edu.ea_day3_crudwithdb.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.entity.ActivityLog;
import miu.edu.ea_day3_crudwithdb.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {

    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(miu.edu.ea_day3_crudwithdb.annotation.ExecutionTime)")
    public void activityLogAnnotation(){

    }

    @Around("activityLogAnnotation()")
    public Object logActivity(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        var activityLogEntity = new ActivityLog();
        activityLogEntity.setDate(LocalDate.now());
        activityLogEntity.setDuration(executionTime);
        activityLogEntity.setOperation(String.valueOf(joinPoint.getSignature()));
        activityLogService.logActivity(activityLogEntity);
        System.out.println(joinPoint.getSignature() + "executed in " + executionTime + "ms" + "at " + LocalDate.now());
        return proceed;
    }

}
