package ru.otus.spring.event.publisher.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.event.BookEvent;
import ru.otus.spring.event.publisher.BookEventPublisher;

@Service
@RequiredArgsConstructor
public class BookEventPublisherImpl implements BookEventPublisher {

    private final ApplicationEventPublisher publisher;
    private final BookDao bookDao;

    @Override
    public void publishBooks(String key) {
        publisher.publishEvent(new BookEvent(this, bookDao, key));
    }
}
