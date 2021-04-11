package ru.otus.spring.repository;

import java.util.Optional;

import ru.otus.spring.domain.Book;

public interface BookRepositoryCustom {

    Optional<Book> findByIdWithComments(long id);
}
