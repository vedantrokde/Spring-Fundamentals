package com.spring.dependencyInjection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    // constructor dependency injection
    @Autowired  // can be avoided as only one arg in constructor
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    // define init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TennisCoach: inside method doMyStartupStuff");
    }

    // define destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TennisCoach: inside method doMyCleanupStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}