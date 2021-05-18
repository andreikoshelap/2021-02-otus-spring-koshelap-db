package ru.otus.spring.repository.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.model.Harbour;
import ru.otus.spring.model.Ship;
import ru.otus.spring.repository.HarbourRepositoryCustom;

public class HarbourRepositoryCustomImpl implements HarbourRepositoryCustom {

    private final ReactiveMongoTemplate mongoTemplate;

    public HarbourRepositoryCustomImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Flux<Harbour> findByHarbourPart(String namePart) {
        Query query = new Query();
        Harbour harbour = new Harbour();
        harbour.setName(namePart);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("name")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Harbour> harbourExample = Example.of(harbour, matcher);
        query.addCriteria(Criteria.byExample(harbourExample));
        return mongoTemplate.find(query, Harbour.class);
    }

    public Mono<Harbour> save(Mono<Harbour> harbourMono) {
        return mongoTemplate.save(harbourMono);
    }

}
