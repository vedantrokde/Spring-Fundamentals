package com.springAop.before.dao;

import com.springAop.before.model.Account;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    private String level;
    private String service;
    
    public String getLevel() {
        System.out.println(getClass() + ": DOING MY DB WORK: getLevel()");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + ": DOING MY DB WORK: setLevel()");
        this.level = level;
    }

    public String getService() {
        System.out.println(getClass() + ": DOING MY DB WORK: getService()");
        return service;
    }

    public void setService(String service) {
        System.out.println(getClass() + ": DOING MY DB WORK: setService()");
        this.service = service;
    }

    public void addAccount(Account account, Boolean   isActive){
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY DB WORK: doWork()");
        return true;
    }
}
