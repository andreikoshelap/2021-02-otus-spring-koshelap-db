package ru.otus.spring.event;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.CommentDao;
import ru.otus.spring.domain.Comment;

public class BookEvent extends ApplicationEvent {

    @Getter
    private List<String> payload;

    public BookEvent(Object source, BookDao bookDao, String key) {
        super(source);
        payload = bookDao.getBooksListByGenre(key).stream().map(book ->
                String.format("id=%d %s, author is %s %s", book.getId(), book.getName(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(toList());
    }

    public BookEvent(Object source, BookDao bookDao, int id) {
        super(source);
        payload = bookDao.getById(id).getComments().stream().map(comment ->
                String.format("comment: %s", comment.getCommentText()))
                .collect(toList());
        if(payload.isEmpty()) {
            payload = Arrays.asList("This book has not had comments yet");
        }
    }

    public BookEvent(Object source, BookDao bookDao, CommentDao commentDao, int id, String commentText) {
        super(source);
        Comment comment = new Comment();
        comment.setCommentText(commentText);
        payload  = bookDao.getCommentsByBookId(id, comment).stream().map(book ->
                String.format("comment: %s",book.getCommentText()))
                .collect(toList());;
    }
}
