package ru.otus.spring.repository;

import java.util.List;

import ru.otus.spring.domain.Book;

public interface BookRepositoryCustom {

    List<Book> findByIdWithComments(long id);
}
