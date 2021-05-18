package ru.otus.spring.repository;

import reactor.core.publisher.Flux;
import ru.otus.spring.model.Ship;

public interface ShipRepositoryCustom {
        Flux<Ship> findByShipNamePart(String shipNamePart);
        Flux<Ship> findByCaptainPart(String captain);
}
