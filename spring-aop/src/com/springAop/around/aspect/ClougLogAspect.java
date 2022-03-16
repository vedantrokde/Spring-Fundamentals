package com.springAop.around.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ClougLogAspect {    
    @Before("com.springAop.around.aspect.PointcutExpressions.forDaoPackage()")
    public void logToCloudAsync() {
        System.out.println("===> Logging to Cloud asynchronously");
    }
}