package com.spring.dependencyInjection;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on batting practice.";
    }

    @Override
    public String getDailyFortune() {
        // use fortuneserive to get a fortune
        return fortuneService.getFortune();
    }
}
