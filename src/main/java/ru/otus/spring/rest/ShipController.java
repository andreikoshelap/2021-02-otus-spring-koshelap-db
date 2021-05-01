package ru.otus.spring.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ru.otus.spring.model.Ship;
import ru.otus.spring.repository.ShipRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> getAllShips(@RequestParam(required = false) String name) {
        try {
            List<Ship> ships = new ArrayList<>();

            if (name == null) {
                shipRepository.findAll().forEach(ships::add);
            }else {

                Ship ship = new Ship();
                ship.setName( name );
                ExampleMatcher matcher = ExampleMatcher.matching()
                        .withIgnoreCase("name")
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
                Example<Ship> tutorialExample = Example.of(ship, matcher);
                shipRepository.findAll(tutorialExample).forEach(ships::add);
            }
            if (ships.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ships, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ships/{id}")
    public ResponseEntity<Ship> getShipById(@PathVariable("id") String id) {
        Optional<Ship> tutorialData = shipRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/ships/captain")
//    public ResponseEntity<List<Ship>> findByPublished() {
//        try {
//            List<Ship> tutorials = shipRepository.findByPublished(true);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/ships")
    public ResponseEntity<Ship> createTutorial(@RequestBody Ship ship) {
        try {
            Ship _ship = shipRepository.save(new Ship(ship.getName(), ship.getCaptain()));
            return new ResponseEntity<>(_ship, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ships/{id}")
    public ResponseEntity<Ship> updateTutorial(@PathVariable("id") String id, @RequestBody Ship ship) {
        Optional<Ship> shipData = shipRepository.findById(id);

        if (shipData.isPresent()) {
            Ship _ship = shipData.get();
            _ship.setName(ship.getName());
            _ship.setCaptain(ship.getCaptain());
            return new ResponseEntity<>(shipRepository.save(_ship), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ships/{id}")
    public ResponseEntity<HttpStatus> deleteShip(@PathVariable("id") String id) {
        try {
            shipRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ships")
    public ResponseEntity<HttpStatus> deleteAllShips() {
        try {
            shipRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}