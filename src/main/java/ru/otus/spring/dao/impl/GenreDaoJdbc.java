package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.dao.mapper.GenreMapper;
import ru.otus.spring.domain.Genre;

@Repository
public class GenreDaoJdbc implements GenreDao {


    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public GenreDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Genre getByKey(String key) {
        Map<String, Object> params = Collections.singletonMap("key", key);
        return namedParameterJdbcOperations.queryForObject(
                "select * from genre where substring(genre_name, 1, 1) = :key", params, new GenreMapper()
        );
    }

    @Override
    public void insert(Genre genre) {
        namedParameterJdbcOperations.update("insert into genre (id, 'genre_name') values (:id, :genre_name)",
                Map.of("id", genre.getId(), "genre_name", genre.getGenreName()));
    }

    @Override
    public List<Genre> getGenreList() {
        return namedParameterJdbcOperations.query(
                "select * from genre order by genre_name",
                (resultSet, rowNum) -> {
                    int genreId = resultSet.getInt("id");
                    String genreName = resultSet.getString("genre_name");
                    return new Genre(genreId, genreName);
                });
    }

}
