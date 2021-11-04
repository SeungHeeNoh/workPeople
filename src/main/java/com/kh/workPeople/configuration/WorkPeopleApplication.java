package com.kh.workPeople.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kh.workPeople")
public class WorkPeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkPeopleApplication.class, args);
	}

}
