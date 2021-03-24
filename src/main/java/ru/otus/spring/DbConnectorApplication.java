package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DbConnectorApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DbConnectorApplication.class, args);
	}
}
