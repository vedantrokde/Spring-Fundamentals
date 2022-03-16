package com.springAop.afterReturning.aspect;

import java.util.List;

import com.springAop.afterReturning.model.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    // afterReturning advice for loggingAspect
    @AfterReturning(pointcut = "execution(* com.springAop.afterReturning.dao.AccountDao.findAccounts(..))", returning = "result")
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
    @Before("com.springAop.afterReturning.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
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
