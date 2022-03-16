package com.spring.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    // Field Injection using Java Reflection
    @Autowired
    @Qualifier("restFortuneService") // specifying particular class object to inject in case of having multiple implementations of interface FortuneServices
    private FortuneService fortuneService;

    public BaseballCoach(){
        System.out.println("BaseballCoach: Inside default constructor.");
    }

    // setter dependency injection
    // @Autowired
    // public void setFortuneService(FortuneService fortuneService){
    //     System.out.println("BaseballCoach: Inside setFOrtuneService.");
    //     this.fortuneService = fortuneService;
    // }

    // method injection
    // @Autowired
    // public void doSomeCrazyStuff(FortuneService fortuneService){
    //     System.out.println("BaseballCoach: Inside doSomeCrazyStuff method.");
    //     this.fortuneService = fortuneService;
    // }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}