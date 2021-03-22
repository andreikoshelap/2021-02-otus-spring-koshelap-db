package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.Map;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.dao.mapper.GenreMapper;
import ru.otus.spring.domain.Genre;

@Repository
public class GenreDaoJdbc implements GenreDao {


    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final JdbcOperations jdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
    }

    @Override
    public Genre getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select * from book where id = :id", params, new GenreMapper()
        );
    }

    @Override
    public void insert(Genre genre) {
        namedParameterJdbcOperations.update("insert into genre (id, 'name') values (:id, :name)",
                Map.of("id", genre.getId(), "name", genre.getJenreName()));
    }



}
