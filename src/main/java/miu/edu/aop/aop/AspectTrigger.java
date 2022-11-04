package miu.edu.aop.aop;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.dto.ActivityLogDTO;
import miu.edu.aop.exception.AopIsAwesomeHeaderException;
import miu.edu.aop.service.ActivityService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class AspectTrigger {

    private final ActivityService activityService;
    private final HttpServletRequest servletRequest;

    @Pointcut("@annotation(miu.edu.aop.annotation.ExecutionTime)")
    void triggerExecutionTime() {}

    @Pointcut("within(miu.edu.aop.service.*)")
    void triggerService() {}

    @Around("triggerExecutionTime()")
    Object triggeredExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long started = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        String operation = joinPoint.getSignature().getName();
        long duration = System.currentTimeMillis() - started;
        LocalDateTime date = LocalDateTime.now();
        activityService.save(new ActivityLogDTO(null, date, operation, duration));
        return object;
    }

    @Before("triggerService()")
    void triggeredService(JoinPoint joinPoint) throws RuntimeException {
        if (Objects.equals(servletRequest.getMethod(), HttpMethod.POST.toString()) && Objects.isNull(servletRequest.getHeader("AOP-IS-AWESOME"))) {
            throw new AopIsAwesomeHeaderException();
        }
    }

}
