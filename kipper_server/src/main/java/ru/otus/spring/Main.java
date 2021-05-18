package ru.otus.spring;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import ru.otus.spring.model.Harbour;
import ru.otus.spring.model.Ship;
import ru.otus.spring.repository.HarbourRepository;
import ru.otus.spring.repository.ShipRepository;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        HarbourRepository repository = context.getBean(HarbourRepository.class);
        ShipRepository shipRepository = context.getBean(ShipRepository.class);

        Harbour pirita =  new Harbour("Pirita");
        repository.saveAll(Arrays.asList(
                pirita,
                new Harbour("Naissaar")
        )).subscribe(p -> System.out.println(p.getName()));

        shipRepository.saveAll(Arrays.asList(
                new Ship("sail", "Apollo", "Koshelap", pirita),
                new Ship("sail", "Mari", "Tonniste", pirita)
        )).subscribe(p -> System.out.println(p.getName()));
    }

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(HarbourRepository repository) {
        return route()
                .GET("/func/harbour", queryParam("name", StringUtils::isNotEmpty),
                        request -> request.queryParam("name")
                                .map(repository::findAllByName)
                                .map(harbour -> ok().body(harbour, Harbour.class))
                                .orElse(notFound().build())
                )
                .GET("/func/harbour", accept(APPLICATION_JSON),
                        request -> ok().contentType(APPLICATION_JSON).body(repository.findAll(), Harbour.class))
                .GET("/func/harbour/{id}", accept(APPLICATION_JSON),
                        request -> repository.findById(request.pathVariable("id"))
                                .flatMap(harbour -> ok().contentType(APPLICATION_JSON).body(fromObject(harbour)))
                ).build();
    }
}


