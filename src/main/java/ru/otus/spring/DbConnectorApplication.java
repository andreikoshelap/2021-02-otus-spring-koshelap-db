package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DbConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbConnectorApplication.class, args);
	}
}
