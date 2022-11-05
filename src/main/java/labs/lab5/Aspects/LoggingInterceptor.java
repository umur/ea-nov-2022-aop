package labs.lab5.Aspects;

import labs.lab5.Anotations.ExecutionTime;
import labs.lab5.Entity.ActivityLog;
import labs.lab5.Service.ActivityLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDate;

@Aspect
@Slf4j
@Component
@AllArgsConstructor

public class LoggingInterceptor {
    ActivityLogService activityLogService;

    @Pointcut("execution(* labs.lab5.Controller.*.*(..))")
    public void logger() {
    }

    @Around("logger()")
    public Object aroundIntercepter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        long start = System.nanoTime();
        res = joinPoint.proceed();
        long end = System.nanoTime();

        if (method.isAnnotationPresent(ExecutionTime.class)) {
            double duration = (end - start) / (100000000.0);
            ActivityLog activityLog = new ActivityLog(LocalDate.now(), method.getName(), duration);
            this.activityLogService.addLogEntry(activityLog);
        }

        return res;
    }
}
