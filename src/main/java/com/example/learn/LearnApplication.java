package com.example.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
	ApplicationContext context= SpringApplication.run(LearnApplication.class, args);
	Dress dress = context.getBean(Dress.class);
		dress.wear();
	}

}
