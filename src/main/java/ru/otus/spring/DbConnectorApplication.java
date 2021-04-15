package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.cloudyrock.spring.v5.EnableMongock;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class DbConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbConnectorApplication.class, args);
	}
}
