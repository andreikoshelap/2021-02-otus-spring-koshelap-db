package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.model.Ship;
import ru.otus.spring.repository.ShipRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ShipController {

    private ShipRepository shipRepository;

    public ShipController(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @GetMapping("/ships")
    public Flux<Ship> getAllShips() {
               return shipRepository.findAll();
    }

    @GetMapping("/ship/name")
    public Flux<Ship> getAllShipsByName(@RequestParam("name") String name) {
               return shipRepository.findAllByName(name);
    }

    @GetMapping("/ship/{id}")
    public Mono<Ship> getShipById(@PathVariable("id") String id) {
        return shipRepository.findById(id);
    }

    @GetMapping("/ship/captain")
    public Flux<Ship> findByCaptain(@RequestParam(required = false) String name) {
            return shipRepository.findAllByCaptain(name);
    }

    @GetMapping("/ship/captain/part")
    public Flux<Ship> findByCaptainPart(@RequestParam(required = false) String name) {
            return shipRepository.findByCaptainPart(name);
    }

}