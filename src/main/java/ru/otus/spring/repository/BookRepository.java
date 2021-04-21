package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import ru.otus.spring.domain.Book;

@EnableMongoRepositories
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
