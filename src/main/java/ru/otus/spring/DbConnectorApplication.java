package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;

@SpringBootApplication
public class DbConnectorApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DbConnectorApplication.class, args);

		AuthorDao authorDao = context.getBean(AuthorDao.class);
		GenreDao genreDao = context.getBean(GenreDao.class);
		BookDao bookDao = context.getBean(BookDao.class);

		System.out.println("All count " + bookDao.count());
	}
}
