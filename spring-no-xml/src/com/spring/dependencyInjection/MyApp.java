package com.spring.dependencyInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        // load spring java configuration file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // retrieve bean from spring container
        BaseballCoach theCoach = context.getBean("baseballCoach", BaseballCoach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());

        // close the context
        context.close();
    }
}