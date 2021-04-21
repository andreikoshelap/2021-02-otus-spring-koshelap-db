package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import ru.otus.spring.repository.BookRepository;

@SpringBootApplication
@EnableConfigurationProperties
public class DbConnectorApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DbConnectorApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);


		System.out.println("\n\n\n----------------------------------------------\n\n");
		System.out.println("Авторы в БД:");
		repository.findAll().forEach(p -> System.out.println(p.getName()));
		System.out.println("\n\n----------------------------------------------\n\n\n");
	}
}
