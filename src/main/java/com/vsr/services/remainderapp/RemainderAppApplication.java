package com.vsr.services.remainderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com")
public class RemainderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemainderAppApplication.class, args);
	}

}
