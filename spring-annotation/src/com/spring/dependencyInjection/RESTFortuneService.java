package com.spring.dependencyInjection;

import org.springframework.stereotype.Component;

@Component("restFortuneService")
// as for this case not only first but second letter is in uppercase thus no default bean id will be created. one has to pass one manually.
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your random day!";
    }
    
}