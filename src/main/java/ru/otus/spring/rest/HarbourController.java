package ru.otus.spring.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.otus.spring.repository.HarbourRepository;
import ru.otus.spring.rest.dto.HarbourDto;

@RestController
public class HarbourController {

    private final HarbourRepository repository;

    @Autowired
    public HarbourController(HarbourRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/harbours")
    public List<HarbourDto> getAllHarbours() {
        return repository.findAll().stream().map(HarbourDto::toDto)
                .collect(Collectors.toList());
    }
}
