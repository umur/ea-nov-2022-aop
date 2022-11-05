package labs.lab5.Aspects;

import labs.lab5.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class HeaderChecker {

    @Pointcut("execution(* labs.lab5.Service.*.*(..))")
    public void checker() {
    }

    @Before("checker()")
    public void checkHeader(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        if (request.getHeader("AOP-IS-AWESOME") == null && (request.getMethod().equals("POST"))) {
            throw new AopIsAwesomeHeaderException("", new Error());
        }

    }
}
