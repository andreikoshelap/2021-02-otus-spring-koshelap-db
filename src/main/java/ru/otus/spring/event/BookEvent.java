package ru.otus.spring.event;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

public class BookEvent extends ApplicationEvent {

    public static final String BOOK_FORMATTER = "id=%d %s, author is %s %s";
    public static final String COMMENT_FORMATTER = "comment: %s";
    @Getter
    private List<String> payload = new ArrayList<>();

    public BookEvent(Object source, BookDao bookDao, String key) {
        super(source);
        payload = bookDao.getBooksListByGenre(key).stream().map(book ->
                String.format(BOOK_FORMATTER, book.getId(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(toList());
    }

    public BookEvent(Object source, BookDao bookDao, int id) {
        super(source);
        Book book = bookDao.getById(id);
        payload.add(String.format(BOOK_FORMATTER, book.getId(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
        List<Comment> comments = book.getComments();
        if (comments.isEmpty()) {
            payload.add("This book has not had comments yet");
        } else {
            payload.addAll(comments.stream().map(comment ->
                    String.format("comment: %s", comment.getCommentText()))
                    .collect(toList()));
        }
    }

    public BookEvent(Object source, BookDao bookDao, int id, String commentText) {
        super(source);
        Book book = bookDao.getById(id);
        payload.add(String.format(BOOK_FORMATTER, book.getId(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
        Comment comment = new Comment();
        comment.setCommentText(commentText);
        payload.addAll(bookDao.getCommentsByBookId(id, comment).stream().map(b ->
                String.format(COMMENT_FORMATTER, b.getCommentText()))
                .collect(toList()));
    }
}
