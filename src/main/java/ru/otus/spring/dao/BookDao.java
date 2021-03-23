package ru.otus.spring.dao;

import java.util.List;

import ru.otus.spring.domain.Book;

public interface BookDao {

    Book getById(int i);

    void insert(Book book);

    List<Book> getBooksList(String genreKey);
}
