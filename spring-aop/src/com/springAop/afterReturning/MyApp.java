package com.springAop.afterReturning;

import java.util.List;

import com.springAop.afterReturning.dao.AccountDao;
import com.springAop.afterReturning.model.Account;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // call method to find the accounts
        List<Account> accounts = accountDao.findAccounts();

        System.out.println("Main Program: MyApp-AfterReturning");
        System.out.println(accounts);

        // close the context
        context.close();
    }
}
