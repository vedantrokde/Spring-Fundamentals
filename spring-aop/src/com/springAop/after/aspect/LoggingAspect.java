package com.springAop.after.aspect;

import java.util.List;

import com.springAop.after.model.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    // after(finally) advice for loggingAspect
    @After("execution(* com.springAop.after.dao.AccountDao.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @After on method: " + method);
    }

    // afterThrowing advice for loggingAspect
    @AfterThrowing(
        pointcut = "execution(* com.springAop.after.dao.AccountDao.findAccounts(..))",
        throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        // print out the method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @AfterThrowing on method: " + method);

        // logt the exception
        System.out.println("===> Exception: " + exc);
    }

    // afterReturning advice for loggingAspect
    @AfterReturning(pointcut = "execution(* com.springAop.after.dao.AccountDao.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out the method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        System.out.println("===> Result: " + result);

        // let's post process the data
        if (result != null) {
            convertAccountNamesToUpperCase(result);
        }
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String tempName = account.getName().toUpperCase();
            account.setName(tempName);
        }
    }

    // before advice for loggingAspect
    @Before("com.springAop.after.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("===> Executing @Before Advice on method ");

        // display method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object object : args) {
            System.out.println(object);
            if (object instanceof Account) {
                Account account = (Account) object;
                System.out.println("Account Name: " + account.getName());
                System.out.println("Account Email: " + account.getEmail());
            }
        }
    }
}
