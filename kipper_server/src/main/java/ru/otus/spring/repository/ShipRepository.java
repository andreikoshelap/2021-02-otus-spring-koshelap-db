package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.model.Ship;

public interface ShipRepository extends ReactiveMongoRepository<Ship, String>, ShipRepositoryCustom {

    Flux<Ship> findAll();

    Mono<Ship> findById(String id);

    Flux<Ship> findAllByName(String name);

    Flux<Ship> findAllByCaptain(String captain);
}
