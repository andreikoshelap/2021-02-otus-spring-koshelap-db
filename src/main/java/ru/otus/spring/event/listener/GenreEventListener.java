package ru.otus.spring.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import ru.otus.spring.event.GenreEvent;

@Component
public class GenreEventListener implements ApplicationListener<GenreEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(GenreEvent genreEvent) {
        Thread.sleep(100);
        genreEvent.getPayload().forEach(genre->
            System.out.println(String.format("- %s (%s)", genre, genre.charAt(0))));
    }
}
