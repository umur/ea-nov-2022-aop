package com.example.lab3.aspect;

import com.example.lab3.exception.AopIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class RequestHeaderAspect {
    @Autowired
    private final HttpServletRequest request;
    @Pointcut("within(com.example.lab3.service..*)")
    public void findRequestHeader(){}

    @Before("findRequestHeader()")
    public void findHeader(){
        if("POST".equalsIgnoreCase(request.getMethod())){
            var header = request.getHeader("AOP-IS-AWESOME");
            if(Objects.isNull(header) || header.isBlank()){
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header not found");
            }
        }
    }
}
