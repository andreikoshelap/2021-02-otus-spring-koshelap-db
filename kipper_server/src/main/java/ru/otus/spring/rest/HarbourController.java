package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import ru.otus.spring.model.Harbour;
import ru.otus.spring.repository.HarbourRepository;

@RestController
public class HarbourController {

    private HarbourRepository repository;

    public HarbourController(HarbourRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/harbours")
    public Flux<Harbour> getAllHarbours() {
        return repository.findAll();
    }
}
