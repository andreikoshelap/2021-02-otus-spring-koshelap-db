package ru.otus.spring.repository;

import java.util.List;

import ru.otus.spring.model.Ship;

public interface ShipRepositoryCustom {
        List<Ship> findByShipNamePart(String shipNamePart);
        List<Ship> findByCaptain(String captain);
}
