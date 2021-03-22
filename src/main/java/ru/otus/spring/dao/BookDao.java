package ru.otus.spring.dao;

import ru.otus.spring.domain.Book;

public interface BookDao {

    Book getById(int i);

    void insert(Book book);

    String count();
}
