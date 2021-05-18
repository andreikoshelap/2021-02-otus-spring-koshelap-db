package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import ru.otus.spring.model.Ship;

@EnableMongoRepositories
@Repository
public interface ShipRepository extends MongoRepository<Ship, String>, ShipRepositoryCustom{

}
