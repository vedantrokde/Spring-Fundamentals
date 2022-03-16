package com.spring.inversionOfControl;

public class FoodCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins on cutting practice.";
    }

}
