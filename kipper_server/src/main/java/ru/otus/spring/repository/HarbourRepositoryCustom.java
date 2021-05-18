package ru.otus.spring.repository;

import reactor.core.publisher.Flux;
import ru.otus.spring.model.Harbour;

public interface HarbourRepositoryCustom {

        Flux<Harbour> findByHarbourPart(String harbourPart);
}
