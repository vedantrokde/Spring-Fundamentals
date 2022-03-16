package com.springAop.afterReturning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {
    @Pointcut("execution(* com.springAop.afterReturning.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* get*(..))")
    public void forGetter(){}

    @Pointcut("execution(* set*(..))")
    public void forSetter(){}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterSetter(){}
}
