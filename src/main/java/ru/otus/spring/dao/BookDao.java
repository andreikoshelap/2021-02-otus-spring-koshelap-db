package ru.otus.spring.dao;

import java.util.List;

import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

public interface BookDao {

    Book getById(long i);

    Book save(Book book);

    List<Book> getBooksListByGenre(String genreKey);

    List<Comment> getCommentsByBookId(long id, Comment commentText);
}
