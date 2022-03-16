package com.springAop.afterThrowing.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {
   @Before("com.springAop.afterThrowing.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("===> Performing API Analytics");
    }
}
