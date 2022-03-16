package com.springAop.around;

import java.util.logging.Logger;

import com.springAop.around.service.TrafficFortuneService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    private static Logger logger = Logger.getLogger(MyApp.class.getName());
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main Program: MyApp - Around");
        logger.info("Calling getFortune");

        boolean tripWire = true;
        String data = null; 
        
        try {
            data = trafficFortuneService.getFortune(tripWire);
        } catch (Exception e) {
            logger.info("Accident is dealt in Main class");
        }
        
        logger.info("My fortune is: " + data);
        logger.info("Finished!");

        // close the context
        context.close();
    }
}
