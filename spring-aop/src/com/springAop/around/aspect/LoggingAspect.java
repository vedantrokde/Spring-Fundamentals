package com.springAop.around.aspect;

import java.util.List;
import java.util.logging.Logger;

import com.springAop.around.model.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());
    // around advice for loggingAspect
    @Around("execution(* com.springAop.around.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // print out the method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("===> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());

            // handle exception
            // result = "Major accident! But no worries, your private AOP helicopter is on the way!";

            // rethrow exception
            throw e;
        }

        // get end timestamp and compute duration and display it
        logger.info("===> Time taken in @Around: " + (System.currentTimeMillis()-begin)/1000.0 + "seconds.");

        return result;
    }

    // after(finally) advice for loggingAspect
    @After("execution(* com.springAop.around.dao.AccountDao.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> Executing @After on method: " + method);
    }

    // afterThrowing advice for loggingAspect
    @AfterThrowing(
        pointcut = "execution(* com.springAop.around.dao.AccountDao.findAccounts(..))",
        throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        // print out the method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> Executing @AfterThrowing on method: " + method);

        // logt the exception
        logger.info("===> Exception: " + exc);
    }

    // afterReturning advice for loggingAspect
    @AfterReturning(pointcut = "execution(* com.springAop.around.dao.AccountDao.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out the method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        logger.info("===> Result: " + result);

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
    @Before("com.springAop.around.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("===> Executing @Before Advice on method ");

        // display method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + signature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object object : args) {
            logger.info(object.toString());
            if (object instanceof Account) {
                Account account = (Account) object;
                logger.info("Account Name: " + account.getName());
                logger.info("Account Email: " + account.getEmail());
            }
        }
    }
}
