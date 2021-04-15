package ru.otus.spring.event.publisher.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.event.GenreEvent;
import ru.otus.spring.event.publisher.GenreEventsPublisher;

@Service
@RequiredArgsConstructor
public class GenreEventPublisherImpl implements GenreEventsPublisher {

    private final ApplicationEventPublisher publisher;
    private final GenreRepository genreRepository;

    @Override
    public void publishGenre() {
        publisher.publishEvent(new GenreEvent(this, genreRepository));
    }
}
