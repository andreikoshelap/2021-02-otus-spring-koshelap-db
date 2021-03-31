package ru.otus.spring.event;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.dao.BookDao;

public class BookEvent extends ApplicationEvent {

    @Getter
    private List<String> payload;

    public BookEvent(Object source, BookDao bookDao, String key) {
        super(source);
        payload = bookDao.getBooksList(key).stream().map(book ->
                String.format("%s, author is %s %s", book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(toList());
    }

    public BookEvent(Object source, BookDao bookDao, String key, int bookKey) {
        super(source);
        payload = bookDao.getBook(key, bookKey).getComments().stream().map(comment ->
                String.format("comment: %s", comment.getCommentText()))
                .collect(toList());
    }

    public BookEvent(Object source, BookDao bookDao, String key, int bookKey, String comment) {
        super(source);
        payload  = bookDao.addComment(key, bookKey, comment).stream().map(book ->
                String.format("comment: %s",book.getCommentText()))
                .collect(toList());;
    }
}
