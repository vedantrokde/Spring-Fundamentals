package com.spring.dependencyInjection;

public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
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