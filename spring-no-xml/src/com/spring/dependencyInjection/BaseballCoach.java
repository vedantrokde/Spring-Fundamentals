package com.spring.dependencyInjection;

import org.springframework.beans.factory.annotation.Value;

public class BaseballCoach implements Coach {

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        System.out.println("BaseballCoach: Inside default constructor.");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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