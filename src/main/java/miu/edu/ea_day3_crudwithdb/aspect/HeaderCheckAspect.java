package miu.edu.ea_day3_crudwithdb.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class HeaderCheckAspect {

    private final HttpServletRequest httpServletRequest;

    @Pointcut("execution(* miu.edu.ea_day3_crudwithdb.service.*.*(..))")
    public void CheckHttpPostHeaderPointCut() {

    }

    @Before("CheckHttpPostHeaderPointCut()")
    public void CheckHeaderBehaviour(JoinPoint joinpoint)
            throws AopIsAwesomeHeaderException {
        if (httpServletRequest.getMethod().equals("POST")) {
            if (httpServletRequest.getHeader("AOP-IS-AWESOME") == null) {
                throw new AopIsAwesomeHeaderException("'AOP-IS-AWESOME' is not given in header");
            }
        }
    }

}
