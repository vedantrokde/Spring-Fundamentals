package com.springAop.afterThrowing;

import java.util.List;

import com.springAop.afterThrowing.dao.AccountDao;
import com.springAop.afterThrowing.model.Account;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // call method to find the accounts
        List<Account> accounts = null;
        
        try {
            // add boolean flag to simulate exception
            boolean tripWire = true;
            accounts = accountDao.findAccounts(tripWire);    
        } catch (Exception e) {
            System.out.println("Caught exception in Main app..." + e);
        }
        
        System.out.println("Main Program: MyApp-AfterThrowing");
        System.out.println(accounts);

        // close the context
        context.close();
    }
}
