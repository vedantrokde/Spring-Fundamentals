package com.springAop.before;

import com.springAop.before.dao.AccountDao;
import com.springAop.before.dao.MembershipDao;
import com.springAop.before.model.Account;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

        // calling getter/setter
        accountDao.setService("service");
        String service = accountDao.getService();
        accountDao.setLevel("22");
        String level = accountDao.getLevel();

        System.out.println(service + " " + level);

        // call the buisness method
        Account account = new Account("Ramesh", "ramesh@demo.com");
        accountDao.addAccount(account, true);
        accountDao.doWork();
        membershipDao.addUser();
        membershipDao.goToSleep();

        // close the context
        context.close();
    }
}
