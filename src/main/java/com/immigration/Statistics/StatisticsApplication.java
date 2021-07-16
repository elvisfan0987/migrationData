package com.immigration.Statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class StatisticsApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
	}
}
