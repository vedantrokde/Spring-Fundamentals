package com.spring.inversionOfControl;

public class MyApp {
    public static void main(String[] args) {
        
        // create the object
        Coach theCoach = new FoodCoach();

        // using the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
   