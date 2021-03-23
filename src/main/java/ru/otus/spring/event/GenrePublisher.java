package ru.otus.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;

@Service
@RequiredArgsConstructor
public class GenrePublisher implements EventsPublisher {

    private final ApplicationEventPublisher publisher;
    private final BookDao bookDao;
    private final GenreDao genreDao;

    @Override
    public void publish() {
        publisher.publishEvent(new GenreEvent(this, genreDao));
    }
}
