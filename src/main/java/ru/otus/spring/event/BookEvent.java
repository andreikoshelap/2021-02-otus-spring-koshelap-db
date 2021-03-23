package ru.otus.spring.event;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.domain.Book;

public class BookEvent extends ApplicationEvent {

    @Getter
    private final List<String> payload;

    public BookEvent(Object source, BookDao bookDao, String key) {
        super(source);
        payload  = bookDao.getBooksList(key).stream().map(Book::getName).collect(Collectors.toList());
    }
}
