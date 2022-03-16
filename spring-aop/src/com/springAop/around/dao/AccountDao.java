package com.springAop.around.dao;

import java.util.ArrayList;
import java.util.List;

import com.springAop.around.model.Account;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    private String level;
    private String service;

    // add new methods of findAccount()
    public List<Account> findAccounts(boolean tripWire){

        // simulating an exception
        if(tripWire == true){
            throw new RuntimeException("No soup for you!!");
        }

        List<Account> accounts = new ArrayList<>();

        Account tempAccount1 = new Account("John", "Silver");
        Account tempAccount2 = new Account("Madhu", "Platinum");
        Account tempAccount3 = new Account("Luca", "Gold");

        accounts.add(tempAccount1);
        accounts.add(tempAccount2);
        accounts.add(tempAccount3);
        
        return accounts;
    }
    
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
