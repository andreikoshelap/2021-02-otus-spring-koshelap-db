package ru.otus.spring.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.otus.spring.repository.TripRepository;

@RestController
public class TripController {

    private final TripRepository repository;

    @Autowired
    public TripController(TripRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/api/persons")
//    public List<TripDto> getAllPersons() {
//        return null;
//    }
}
