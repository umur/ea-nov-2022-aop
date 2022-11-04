package miu.edu.lab4.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpRequestInterceptor {

    private HttpServletRequest request;

    public HttpRequestInterceptor(HttpServletRequest request) {
        this.request = request;
    }

    @Pointcut("within(miu.edu.lab4.service..*)")
    public void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void httpHeaderInterceptor() {

        if (request.getMethod().equals("POST")) {
            if(request.getHeader("AOP-IS-AWESOME") == null) {
                throw new RuntimeException("AOP-IS-AWESOME header is missing");
            }
        }
    }





}
