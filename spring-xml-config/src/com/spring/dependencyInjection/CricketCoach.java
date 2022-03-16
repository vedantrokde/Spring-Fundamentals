package com.spring.dependencyInjection;

public class CricketCoach implements Coach {

    private String email;
    private String team;

    private FortuneService fortuneService;

    // create a no-arg constructor
    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    // our setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return "Coach's Email: " + email;
    }

    public void setEmail(String email) {
        System.out.println("CricketCoach: inside setter method - setEmail");
        this.email = email;
    }

    public String getTeam() {
        return "Coach's Team: " + team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15mins.";
    }

    @Override
    public String getDailyFortune() {
        return "Howzat: " + fortuneService.getFortune();
    }
    
}
