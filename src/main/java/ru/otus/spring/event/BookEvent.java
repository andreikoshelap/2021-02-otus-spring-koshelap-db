package ru.otus.spring.event;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepository;

public class BookEvent extends ApplicationEvent {

    public static final String BOOK_FORMATTER = "%d, %s, author is %s %s";
    @Getter
    private List<String> payload;

    public BookEvent(Object source, BookRepository bookRepository, String key) {
        super(source);
        List<Book> query = key.isEmpty() ? bookRepository.findAll() :
                bookRepository.findByGenreGenreKey(key);
        payload = query.stream().map(book ->
                String.format(BOOK_FORMATTER, book.getBookKey(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(toList());
    }

}
