package ru.otus.spring.event;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepository;

public class BookEvent extends ApplicationEvent {

    public static final String BOOK_FORMATTER = "%s, author is %s %s";
    public static final String COMMENT_FORMATTER = "comment: %s";
    @Getter
    private List<String> payload = new ArrayList<>();

    public BookEvent(Object source, BookRepository bookRepository, String key) {
        super(source);
        List<Book> query = key.isEmpty() ? bookRepository.findAll() :
                bookRepository.findByGenreGenreKey(key);
        payload = query.stream().map(book ->
                String.format(BOOK_FORMATTER, book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(toList());
    }

    public BookEvent(Object source, BookRepository bookRepository, String... id) {
        super(source);
        bookRepository.findByIdWithComments(id[0]).stream().findAny().ifPresent(book-> {
            payload.add(String.format(BOOK_FORMATTER, book.getId(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
//            List<Comment> comments = book.getComments();
//            if (comments.isEmpty()) {
//                payload.add("This book has not had comments yet");
//            } else {
//                payload.addAll(comments.stream().map(comment ->
//                        String.format(COMMENT_FORMATTER, comment.getCommentText()))
//                        .collect(toList()));
//            }
        });
    }

    public BookEvent(Object source, BookRepository bookRepository, String id, String commentText) {
        super(source);
//        bookRepository.findByIdWithComments(id).stream().findAny().ifPresent(book-> {
//            payload.add(String.format(BOOK_FORMATTER, book.getId(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
//            List<Comment> comments = book.getComments();
//            Comment comment = new Comment();
//            comment.setCommentText(commentText);
//            book.getComments().add(comment);
//            bookRepository.save(book);
//            payload.addAll(comments.stream().map(c ->
//                        String.format(COMMENT_FORMATTER, c.getCommentText()))
//                        .collect(toList()));
//        });

    }
}
