package com.spring.inversionOfControl;

import org.springframework.stereotype.Component;

// @Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on backhand volley.";
    }
}