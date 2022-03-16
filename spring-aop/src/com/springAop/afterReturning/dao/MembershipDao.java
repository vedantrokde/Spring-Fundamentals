package com.springAop.afterReturning.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public boolean addUser(){
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": DOING MY DB WORK: SLEEPING");
    }
}
