package ru.otus.spring.repository;

import java.util.List;

import ru.otus.spring.model.Ship;

public interface ShipRepositoryCustom {
        List<Ship> findByShipContaining(String shipNamePart);
//        List<Ship> findByPublished(boolean published);
}
