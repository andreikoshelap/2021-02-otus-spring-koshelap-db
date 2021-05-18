package ru.otus.spring.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.spring.model.Harbour;

@RunWith(SpringRunner.class)
@DataMongoTest
public class HarbourRepositoryTest {

    @Autowired
    private HarbourRepository repository;

    @Test
    public void findAllByHabourName() {
        repository.save(new Harbour("Helsinki")).block();
        Flux<Harbour> harbourFlux = repository.findAllByName("Helsinki");

        StepVerifier
                .create(harbourFlux)
                .assertNext(s -> {
                    assertEquals("Helsinki", s.getName());
                    assertNotNull(s.getId());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void checkSaveShip() {
        Mono<Harbour> harbourMono = repository.save(new Harbour("Helsinki"));

        StepVerifier
                .create(harbourMono)
                .assertNext(account -> assertNotNull(account.getId()))
                .expectComplete()
                .verify();
    }
}
