package ru.otus.spring.dao;

import java.util.List;

import ru.otus.spring.domain.Genre;

public interface GenreDao {

    Genre getByKey(String key);

    void insert(Genre book);

    List<Genre> getGenreList();
}
