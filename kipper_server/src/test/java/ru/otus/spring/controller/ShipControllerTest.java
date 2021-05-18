package ru.otus.spring.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipControllerTest {

    @Autowired
    private RouterFunction route;

    @Autowired
    private WebClient webClient;

    WebTestClient client = WebTestClient
            .bindToRouterFunction(route)
            .build();

//        client.get()
//                .uri("/func/person")
//                .exchange()
//                .expectStatus()
//                .isOk();
}
