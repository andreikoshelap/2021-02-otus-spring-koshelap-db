package ru.otus.spring.dao;

import ru.otus.spring.domain.Genre;

public interface GenreDao {

    Genre getById(int i);

    void insert(Genre book);
}
