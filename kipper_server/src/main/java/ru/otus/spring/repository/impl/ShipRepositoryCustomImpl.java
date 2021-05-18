package ru.otus.spring.repository.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.model.Ship;
import ru.otus.spring.repository.ShipRepositoryCustom;

public class ShipRepositoryCustomImpl implements ShipRepositoryCustom {

    private final ReactiveMongoTemplate mongoTemplate;

    public ShipRepositoryCustomImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Flux<Ship> findByCaptainPart(String namePart) {
        Query query = new Query();
        Ship ship = new Ship();
        ship.setCaptain(namePart);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("captain")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Ship> shipExample = Example.of(ship, matcher);
        query.addCriteria(Criteria.byExample(shipExample));
        return mongoTemplate.find(query, Ship.class);
    }

    @Override
    public Flux<Ship> findByShipNamePart(String namePart) {
        Query query = new Query();
        Ship ship = new Ship();
        ship.setName(namePart);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("name")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Ship> shipExample = Example.of(ship, matcher);
        query.addCriteria(Criteria.byExample(shipExample));
        return mongoTemplate.find(query, Ship.class);
    }

    public Mono<Ship> save(Mono<Ship> account) {
        return mongoTemplate.save(account);
    }

}
