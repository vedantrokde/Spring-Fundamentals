package com.code.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to Springboot");

		ConfigurableApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		Alien a = context.getBean(Alien.class);
		System.out.println(a);
	}

}