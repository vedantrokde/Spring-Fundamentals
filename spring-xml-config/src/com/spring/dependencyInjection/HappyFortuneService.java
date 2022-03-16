package com.spring.dependencyInjection;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        String[] fortunes = {"Today is your lucky day!", "Today is your unlucky day!", "Today is your usual day!"};
        return fortunes[new Random().nextInt(3)];
    }
    
}
