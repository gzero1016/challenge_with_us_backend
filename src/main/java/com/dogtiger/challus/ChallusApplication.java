package com.dogtiger.challus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChallusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallusApplication.class, args);
	}

}