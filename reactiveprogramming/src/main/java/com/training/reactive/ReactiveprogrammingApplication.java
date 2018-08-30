package com.training.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication
@EnableReactiveMongoRepositories

public class ReactiveprogrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveprogrammingApplication.class, args);
	}
}
