package ru.otus.spring.dao;

import java.util.List;

import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

public interface BookDao {

    Book getById(long i);

    Book addComment(Book book);

    List<Book> getBooksList(String genreKey);

    Book getBook(String genreKey, int bookKey);

    List<Comment> addComment(String genreKey, int bookKey, String commentText);
}
