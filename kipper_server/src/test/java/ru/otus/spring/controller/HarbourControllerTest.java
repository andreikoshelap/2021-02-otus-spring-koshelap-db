package ru.otus.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HarbourControllerTest {

    @Autowired
    private RouterFunction route;


    @Test
    public void testHarbourRoute() {
        WebTestClient client = WebTestClient
                .bindToRouterFunction(route)
                .build();

        client.get()
                .uri("/func/harbour?name=aa")
                .exchange()
                .expectStatus()
                .isOk();
    }
}