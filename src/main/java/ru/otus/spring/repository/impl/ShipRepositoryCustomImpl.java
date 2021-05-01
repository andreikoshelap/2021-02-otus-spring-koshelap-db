package ru.otus.spring.repository.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.model.Ship;
import ru.otus.spring.repository.ShipRepositoryCustom;

@RequiredArgsConstructor
public class ShipRepositoryCustomImpl implements ShipRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Ship> findByShipContaining(String namePart) {
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

//    @Override
//    public List<Tutorial> findByPublished(boolean published) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("published").is(published));
//        return mongoTemplate.find(query, Tutorial.class);
//    }
}
