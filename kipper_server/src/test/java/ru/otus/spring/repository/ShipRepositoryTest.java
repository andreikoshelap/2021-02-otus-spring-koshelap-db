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
import ru.otus.spring.model.Ship;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ShipRepositoryTest {

    @Autowired
    private ShipRepository repository;

    @Test
    public void findAllByShipName() {
        repository.save(new Ship("Lastochka", "Boikov")).block();
        Flux<Ship> shipFlux = repository.findAllByName("Lastochka");

        StepVerifier
                .create(shipFlux)
                .assertNext(s -> {
                    assertEquals("Lastochka", s.getName());
                    assertEquals("Boikov" , s.getCaptain());
                    assertNotNull(s.getId());
                })
                .thenConsumeWhile(x -> true)
                .verifyComplete();
    }

    @Test
    public void findAllByShipNamePart() {
        repository.save(new Ship("Lastochka", "Boikov")).block();
        Flux<Ship> shipFlux = repository.findByShipNamePart("to");

        StepVerifier
                .create(shipFlux)
                .expectNext()
                .assertNext(s -> {
                    assertEquals("Lastochka", s.getName());
                    assertEquals("Boikov" , s.getCaptain());
                    assertNotNull(s.getId());
                })
                .thenConsumeWhile(x -> true)
                .expectComplete()
                .verify();
    }

    @Test
    public void findByCaptainNamePart() {
        repository.save(new Ship("Lastochka", "Boikov")).block();
        Flux<Ship> shipFlux = repository.findByCaptainPart("bo");

        StepVerifier
                .create(shipFlux)
                .assertNext(s -> {
                    assertEquals("Lastochka", s.getName());
                    assertEquals("Boikov" , s.getCaptain());
                    assertNotNull(s.getId());
                })
                .thenConsumeWhile(x -> true)
                .verifyComplete();
    }

    @Test
    public void checkSaveShip() {
        Mono<Ship> shipMono = repository.save(new Ship("Lastochka", "Boikov"));

        StepVerifier
                .create(shipMono)
                .assertNext(ship -> assertNotNull(ship.getId()))
                .expectComplete()
                .verify();
    }
}
