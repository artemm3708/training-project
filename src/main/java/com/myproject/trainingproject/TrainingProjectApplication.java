package com.myproject.trainingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class TrainingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingProjectApplication.class, args);
	}

}
