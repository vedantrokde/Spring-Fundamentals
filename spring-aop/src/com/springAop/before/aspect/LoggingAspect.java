package com.springAop.before.aspect;

import com.springAop.before.model.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    @Before("com.springAop.before.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("===> Executing @Before Advice on method ");

        // display method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object object : args) {
            System.out.println(object);
            if(object instanceof Account){
                Account account = (Account) object;
                System.out.println("Account Name: " + account.getName());
                System.out.println("Account Email: " + account.getEmail());
            }
        }
    }
}
