package ru.otus.spring.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.model.Harbour;


public interface HarbourRepository extends ReactiveMongoRepository<Harbour, String>,HarbourRepositoryCustom {

    Flux<Harbour> findAll();

    Mono<Harbour> findById(String id);

    Flux<Harbour> findAllByName(String name);
}
