package ru.otus.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.otus.spring.domain.Genre;

public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String genreName = resultSet.getString("genre_name");
        return new Genre(id, genreName);
    }
}
