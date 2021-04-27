package ru.otus.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import ru.otus.spring.domain.Harbour;
import ru.otus.spring.domain.Trip;

@EnableMongoRepositories
@Repository
public interface HarbourRepository extends MongoRepository<Harbour, String>{

    List<Harbour> findAll();
}
