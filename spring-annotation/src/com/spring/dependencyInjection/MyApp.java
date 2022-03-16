package com.spring.dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        // load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}