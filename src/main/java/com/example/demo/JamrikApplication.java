package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JamrikApplication {

	public static void main(String[] args) {
		SpringApplication.run(JamrikApplication.class, args);
        System.out.println("Welcome to Jamrik");
	}

}
