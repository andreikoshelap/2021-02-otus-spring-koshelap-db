package ru.otus.spring.event.publisher.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.event.GenreEvent;
import ru.otus.spring.event.publisher.GenreEventsPublisher;

@Service
@RequiredArgsConstructor
public class GenreEventPublisherImpl implements GenreEventsPublisher {

    private final ApplicationEventPublisher publisher;
    private final GenreDao genreDao;

    @Override
    public void publishGenre() {
        publisher.publishEvent(new GenreEvent(this, genreDao));
    }
}
