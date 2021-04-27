package ru.otus.spring.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.otus.spring.repository.PersonRepository;
import ru.otus.spring.rest.dto.PersonDto;

@RestController
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/persons")
    public List<PersonDto> getAllPersons() {
        return repository.findAll().stream().map(PersonDto::toDto)
                .collect(Collectors.toList());
    }
}
