package ru.otus.spring.dao;

import ru.otus.spring.domain.Author;

public interface AuthorDao {

    Author getById(long i);

    Author save(Author book);

}
