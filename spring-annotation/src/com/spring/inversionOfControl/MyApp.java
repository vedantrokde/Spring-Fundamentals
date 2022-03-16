package com.spring.inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        
        // load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        
        // Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
   