package ru.otus.spring.repository.impl;

import java.util.List;

import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepositoryCustom;

public class BookRepositoryImpl implements BookRepositoryCustom {
    @Override
    public List<Book> findByIdWithComments(long id) {
        return null;
    }
}
