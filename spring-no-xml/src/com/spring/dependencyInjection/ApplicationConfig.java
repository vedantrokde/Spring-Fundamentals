package com.spring.dependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.spring.dependencyInjection")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }

    @Bean
    public Coach tennisCoach() {
        return new TennisCoach(happyFortuneService());
    }

    @Bean
    public BaseballCoach baseballCoach() {
        return new BaseballCoach(happyFortuneService());
    }
    
}
