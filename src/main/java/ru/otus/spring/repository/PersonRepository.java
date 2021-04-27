package ru.otus.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import ru.otus.spring.domain.Person;

@EnableMongoRepositories
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findAll();
}
