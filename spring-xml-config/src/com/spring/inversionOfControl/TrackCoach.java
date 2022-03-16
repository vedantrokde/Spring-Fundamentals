package com.spring.inversionOfControl;

public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on running practice.";
    }
}
